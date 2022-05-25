package com.maktab74.repository;

import java.sql.Connection;

public class BasketRepository {
    private Connection connection;

    public BasketRepository(Connection connection) {
        this.connection = connection;
    }
}
