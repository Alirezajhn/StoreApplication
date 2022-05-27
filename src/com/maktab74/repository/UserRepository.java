package com.maktab74.repository;

import com.maktab74.domain.User;

import java.sql.*;

public class UserRepository {
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public User insert(User user) throws SQLException {
        String insertQuery = "insert into user_table(" +
                "username, firstname ,lastname , phonenumber,email,province,street,city,postalcode,password" +
                ") values (? ,?, ?, ? ,? , ?, ? , ? , ?, ?)";

        PreparedStatement preparedStatement =
                connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setString(3, user.getLastName());
        preparedStatement.setString(4, user.getPhoneNumber());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.setString(6, user.getProvince());
        preparedStatement.setString(7, user.getStreet());
        preparedStatement.setString(8, user.getCity());
        preparedStatement.setString(9, user.getPostalCode());
        preparedStatement.setString(10,user.getPassword());
        preparedStatement.executeUpdate();

        user.setId(getMaxId());

        return user;
    }

    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from user_table");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public User getByUsernameAndPassword(String username, String password) throws SQLException {
        String query = "select * from user_table where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new User(
                    resultSet.getInt(1 ),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11)
            );
        }
        return null;
    }
///////////////////for check username in database//////////////////////////////////////
    public int getUserByUsername(String username) throws SQLException {
        String query = "select * from user_table where username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return 1;
        }
        return 0;
    }

}

