package com.maktab74.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private Connection connection;

    private String databaseUrl;

    private String databaseUser;

    private String databasePassword;

    public DatabaseUtil() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        this.databaseUrl = "jdbc:mysql://localhost:3306";
        this.databaseUser = "root";
        this.databasePassword = "Ajahangard@123";

        this.connection =
                DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);

    }

    public Connection getConnection() {
        return connection;
    }
}
