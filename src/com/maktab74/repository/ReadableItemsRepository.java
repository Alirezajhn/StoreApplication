package com.maktab74.repository;

import java.sql.Connection;

public class ReadableItemsRepository {
    private Connection connection;

    public ReadableItemsRepository(Connection connection) {
        this.connection = connection;
    }
}
