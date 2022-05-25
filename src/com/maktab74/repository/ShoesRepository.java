package com.maktab74.repository;

import java.sql.Connection;

public class ShoesRepository {
    private Connection connection;

    public ShoesRepository(Connection connection) {
        this.connection = connection;
    }
}
