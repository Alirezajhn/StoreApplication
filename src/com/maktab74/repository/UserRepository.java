package com.maktab74.repository;

import java.sql.Connection;

public class UserRepository {
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }
}
