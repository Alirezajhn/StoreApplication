package com.maktab74.repository;

import java.sql.Connection;

public class RadioRepository {
    private Connection connection;

    public RadioRepository(Connection connection) {
        this.connection = connection;
    }
}
