package com.maktab74.repository;

import java.sql.Connection;

public class TvRepository {
    private Connection connection;

    public TvRepository(Connection connection) {
        this.connection = connection;
    }
}
