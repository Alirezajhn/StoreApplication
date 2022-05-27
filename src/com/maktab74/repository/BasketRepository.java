package com.maktab74.repository;

import com.maktab74.domain.Basket;
import com.maktab74.domain.Radio;

import java.sql.*;

public class BasketRepository {
    private Connection connection;

    public BasketRepository(Connection connection) {
        this.connection = connection;
    }
    public  Basket insert(Basket basket) throws SQLException {
        String insertQuery = "insert into basket(" +
                "productid, userid ,numberitem , category" +
                ") values (? , ?, ?, ?)";

        PreparedStatement preparedStatement =
                connection.prepareStatement(insertQuery);
        preparedStatement.setInt(1, basket.getProductId());
        preparedStatement.setInt(2, basket.getUserId());
        preparedStatement.setInt(3, basket.getNumberItem());
        preparedStatement.setString(4, basket.getCategory());
        preparedStatement.executeUpdate();
        basket.setId(getMaxId());

        return basket;
    }


    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from basket");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
}
