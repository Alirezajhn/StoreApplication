package com.maktab74.repository;

import com.maktab74.domain.Basket;
import com.maktab74.domain.Tv;
import com.maktab74.domain.User;

import java.sql.*;

public class TvRepository {
    private Connection connection;

    public TvRepository(Connection connection) {
        this.connection = connection;
    }

    public Tv[] getAllByProductBaseId(int basketId) throws SQLException {
        int countAll = countAllByProductBaseId(basketId);
        if (countAll > 0) {
            Tv[] tv = new Tv[countAll];
            int emptyIndex = 0;

            String query =
                    "select * from tv as t join basket as b " +
                            "on t.basket_tv_id = b.product_id " +
                            "where basket_tv_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, basketId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tv[emptyIndex] =
                        new Tv(
                                resultSet.getInt(1),
                                resultSet.getInt(2),
                                resultSet.getInt(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getString(7),
                                resultSet.getString(8),
                                new Basket(
                                        resultSet.getInt(10),
                                        resultSet.getInt(11),
                                        resultSet.getInt(12),
                                        resultSet.getInt(13),
                                        resultSet.getString(14)
                                )
                        );
                emptyIndex++;
            }
            return tv;
        } else {
            return new Tv[0];
        }

    }

    public int countAllByProductBaseId(int basketId) throws SQLException {
        String query = "select count(*) from tv where basket_tv_id= ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, basketId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public Tv insert(Tv tv) throws SQLException {
        String insertQuery = "insert into user(" +
                "unit, price ,powersource , brand , model, screensize ,qualityResolution, basket_tv_id" +
                ") values (? ,?, ?, ? ,? , ?, ? ,?)";

        PreparedStatement preparedStatement =
                connection.prepareStatement(insertQuery);
        preparedStatement.setInt(1, tv.getUnit());
        preparedStatement.setInt(2, tv.getPrice());
        preparedStatement.setString(3, tv.getPowerSource());
        preparedStatement.setString(4, tv.getBrand());
        preparedStatement.setString(5, tv.getModel());
        preparedStatement.setString(6, tv.getScreenSize());
        preparedStatement.setString(7, tv.getQualityResolution());
        preparedStatement.setInt(8, tv.getBasket().getId());
        preparedStatement.executeUpdate();
        tv.setId(getMaxId());

        return tv;
    }

    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from tv");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

}
