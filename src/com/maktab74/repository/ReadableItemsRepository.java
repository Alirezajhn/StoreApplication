package com.maktab74.repository;

import com.maktab74.domain.Basket;
import com.maktab74.domain.ReadableItems;
import com.maktab74.domain.Shoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadableItemsRepository {
    private Connection connection;

    public ReadableItemsRepository(Connection connection) {
        this.connection = connection;
    }
    //readableItems(product) to basket : many to one
    public ReadableItems[] getAllByProductBaseId(int basketId) throws SQLException {
        int countAll = countAllByProductBaseId(basketId);
        if (countAll > 0) {
           ReadableItems[] readableItems = new ReadableItems[countAll];
            int emptyIndex = 0;

            String query =
                    "select * from readableitems as re join basket as b " +
                            "on re.basket_readableitem_id = b.product_id " +
                            "where basket_readableitam_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, basketId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                readableItems[emptyIndex] =
                        new ReadableItems(
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
            return readableItems;
        } else {
            return new ReadableItems[0];
        }

    }

    public int countAllByProductBaseId(int basketId) throws SQLException {
        String query = "select count(*) from tv where basket_readableitem_id= ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, basketId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
}
