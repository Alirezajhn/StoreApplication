package com.maktab74.repository;

import com.maktab74.domain.User;

import java.sql.*;

public class UserRepository {
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }
    public User insert(User user) throws SQLException {
        String insertQuery = "insert into user(" +
                "username, phonenumber,firstname,lastname,email,address,password" +
                ") values (? ,?, ?, ? ,? , ?, ?)";

        PreparedStatement preparedStatement =
                connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPhoneNumber());
        preparedStatement.setString(3, user.getFirstName());
        preparedStatement.setString(4,user.getLastName());
        preparedStatement.setString(5,user.getEmail());
      // preparedStatement.setString(6,user.getAddress);
        preparedStatement.setString(7, user.getPassword());
        preparedStatement.executeUpdate();

        user.setId(getMaxId());

        return user;
    }

    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from user");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public User getByUsernameAndPassword(String username, String password) throws SQLException {
        String query = "select * from user where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                  //  resultSet.getArray(8)
            );
        }

        return null;
    }

    public void update(User user) throws SQLException{
        String query = "update user set " +
                "password=? where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getPassword());
        preparedStatement.setInt(2, user.getId());
        preparedStatement.executeUpdate();
    }

    public int getUserByUsername(String username) throws SQLException{
        String query = "select * from user where username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return 1;
        }

        return 0;
    }
}

