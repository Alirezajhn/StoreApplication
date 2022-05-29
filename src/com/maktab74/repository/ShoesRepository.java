package com.maktab74.repository;

import com.maktab74.domain.Basket;
import com.maktab74.domain.ReadableItems;
import com.maktab74.domain.Shoes;
import com.maktab74.domain.Tv;

import java.sql.*;
import java.util.ArrayList;

public class ShoesRepository {
    private Connection connection;

    public ShoesRepository(Connection connection) {
        this.connection = connection;
    }
    //shoes(product) to basket : many to one
    private ArrayList<Shoes> shoes = new ArrayList<>();

    public ArrayList<Shoes> getAllShoes() throws SQLException {
        String query =
                "select * from shoe";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Shoes shoe=new Shoes();
            shoe.setId(resultSet.getInt(1));
            shoe.setUnit(resultSet.getInt(2));
            shoe.setPrice(resultSet.getInt(3));
            shoe.setSizeShoes(resultSet.getString(4));
            shoe.setColor(resultSet.getString(5));
            shoe.setTypeShoes(resultSet.getString(6));
            shoes.add(shoe);
        }
        return shoes;
    }

//    public Shoes[] getAllByProductBaseId(int basketId) throws SQLException {
//        int countAll = countAllByProductBaseId(basketId);
//        if (countAll > 0) {
//            Shoes[] shoes = new Shoes[countAll];
//            int emptyIndex = 0;
//
//            String query =
//                    "select * from shoes as s join basket as b " +
//                            "on s.basket_shoes_id = b.product_id " +
//                            "where basket_shoes_id = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1, basketId);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//               shoes[emptyIndex] =
//                        new Shoes(
//                                resultSet.getInt(1),
//                                resultSet.getInt(2),
//                                resultSet.getInt(3),
//                                resultSet.getString(4),
//                                resultSet.getString(5),
//                                resultSet.getString(6),
//                                new Basket(
//                                        resultSet.getInt(8),
//                                        resultSet.getInt(9),
//                                        resultSet.getInt(10),
//                                        resultSet.getInt(11),
//                                        resultSet.getString(12)
//                                )
//                        );
//                emptyIndex++;
//            }
//            return shoes;
//        } else {
//            return new Shoes[0];
//        }
//
//    }

   /* public int countAllByProductBaseId(int basketId) throws SQLException {
        String query = "select count(*) from tv where basket_shoes_id= ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, basketId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }*/
    public Shoes insert(Shoes shoes) throws SQLException {
        String insertQuery = "insert into user(" +
                "unit, price, sizeshoes, color, typeshoes" +
                ") values (? ,?, ?, ? ,? )";

        PreparedStatement preparedStatement =
                connection.prepareStatement(insertQuery);
        preparedStatement.setInt(1, shoes.getUnit());
        preparedStatement.setInt(2, shoes.getPrice());
        preparedStatement.setString(3, shoes.getSizeShoes());
        preparedStatement.setString(4, shoes.getColor());
        preparedStatement.setString(5, shoes.getTypeShoes());
        preparedStatement.executeUpdate();
        shoes.setId(getMaxId());

        return shoes;
    }

    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from shoe");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
}
