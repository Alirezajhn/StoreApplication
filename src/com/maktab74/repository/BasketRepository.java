package com.maktab74.repository;

import com.maktab74.domain.Basket;
import com.maktab74.domain.Radio;
import com.maktab74.domain.Tv;

import java.sql.*;
import java.util.ArrayList;

public class BasketRepository {
    private Connection connection;

    public BasketRepository(Connection connection) {
        this.connection = connection;
    }

    public Basket insert(Basket basket) throws SQLException {
        String insertQuery = "insert into basket(" +
                "product_id, user_id ,numberitem , category" +
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

    private ArrayList<Basket> baskets = new ArrayList<>();

    public ArrayList<Basket> getAllBasket() throws SQLException {
        String query =
                "select * from basket ";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Basket basket = new Basket();
            basket.setId(resultSet.getInt(1));
            basket.setProductId(resultSet.getInt(2));
            basket.setUserId(resultSet.getInt(3));
            basket.setNumberItem(resultSet.getInt(4));
            basket.setCategory(resultSet.getString(5));
            baskets.add(basket);
        }
        return baskets;
    }

    public void delete(Basket basket) throws SQLException {
        String deleteQuery = "DELETE FROM basket WHERE id = ?";
        PreparedStatement preparedStatement =
                connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, basket.getId());
        preparedStatement.executeUpdate();
    }

   // public ArrayList<Basket> getAllBasketWithTV(Basket basket) throws SQLException {
    //    String query ="SELECT * FROM basket AS b JOIN tv AS t on b.product_id=";
  //  }

    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from basket");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
}
