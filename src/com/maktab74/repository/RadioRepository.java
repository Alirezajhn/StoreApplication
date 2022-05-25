package com.maktab74.repository;

import com.maktab74.domain.Basket;
import com.maktab74.domain.Radio;
import com.maktab74.domain.ReadableItems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RadioRepository {
    private Connection connection;

    public RadioRepository(Connection connection) {
        this.connection = connection;
    }
    //radio(product) to basket : many to one
    public Radio[] getAllByProductBaseId(int basketId) throws SQLException {
        int countAll = countAllByProductBaseId(basketId);
        if (countAll > 0) {
            Radio[] radios = new Radio[countAll];
            int emptyIndex = 0;

            String query =
                    "select * from radio as r join basket as b " +
                            "on r.basket_radio_id = b.product_id " +
                            "where basket_radio_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, basketId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
               radios[emptyIndex] =
                        new Radio(
                                resultSet.getInt(1),
                                resultSet.getInt(2),
                                resultSet.getInt(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getString(7),
                                new Basket(
                                        resultSet.getInt(9),
                                        resultSet.getInt(10),
                                        resultSet.getInt(11),
                                        resultSet.getInt(12),
                                        resultSet.getString(13)
                                )
                        );
                emptyIndex++;
            }
            return radios;
        } else {
            return new Radio[0];
        }

    }

    public int countAllByProductBaseId(int basketId) throws SQLException {
        String query = "select count(*) from tv where basket_radio_id= ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, basketId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
}

