package com.maktab74.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private Connection connection;
    private String schemaName = "Store_Application";

    public DatabaseInitializer(Connection connection) {
        this.connection = connection;
    }

    public void init() throws SQLException {
        initSchema();

        initUserTable();

        initBasketTable();

        initRadioTable();

        initReadableItemsTable();

        initShoesTable();

        initTvTable();

    }

    private void initSchema() throws SQLException {
        String createSchemaQuery = "create schema if not exists " + schemaName;

        Statement statement = connection.createStatement();
        statement.executeUpdate(createSchemaQuery);

        statement = connection.createStatement();
        statement.executeUpdate("use " + schemaName);

    }

    private void initUserTable() throws SQLException {
        String createUserTable =
                "create table if not exists user_table" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "username varchar(255) unique," +
                        "firstname varchar(255) ," +
                        "lastname varchar (255) , " +
                        "phonenumber varchar(255) unique," +
                        "email varchar (255)," +
                        "province varchar (255)," +
                        "street varchar (255)," +
                        "city varchar (255)," +
                        "postalcode varchar (255)," +
                        "password varchar(255)," +
                        "primary key (id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createUserTable);
    }

    private void initBasketTable() throws SQLException {

        String createBasketTable =
                "create table if not exists basket" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "product_id int," +
                        "user_id int," +
                        "numberitem int ," +
                        "category varchar(255) ," +
                        "primary key (id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createBasketTable);
    }

    private void initRadioTable() throws SQLException {
        String createRadioTable =
                "create table if not exists radio" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "unit int," +
                        "price int," +
                        "powersource varchar (255) , " +
                        "brand varchar(255) ," +
                        "model varchar (255)," +
                        "waverange varchar(255) ," +
                        "basket_radio_id int,"+
                        "primary key (id)" +
                        "FOREIGN KEY (basket_radio_id) REFERENCES basket(id)," +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createRadioTable);
    }

    private void initReadableItemsTable() throws SQLException {
        String createReadableItemsTable =
                "create table if not exists readableitems" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "unit int," +
                        "price int," +
                        "title varchar(255), " +
                        "brief varchar(255), " +
                        "content varchar (255) , " +
                        "publisher varchar(255) ," +
                        "typeItems varchar (255)," +
                        "basket-readableitem_id int,"+
                        "primary key (id)" +
                        "FOREIGN KEY (basket-readableitem_id) REFERENCES basket(id)," +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createReadableItemsTable);
    }

    private void initShoesTable() throws SQLException {
        String createShoesTable =
                "create table if not exists shoes" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "unit int," +
                        "price int," +
                        "sizeShoes varchar(255), " +
                        "color varchar (255), " +
                        "typeshoes varchar(255)," +
                        "basket_shoes_id int,"+
                        "primary key (id)" +
                        "FOREIGN KEY (basket_shoes_id) REFERENCES basket(id)," +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createShoesTable);
    }

    private void initTvTable() throws SQLException {
        String createTvTable =
                "create table if not exists tv" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "unit int," +
                        "price int," +
                        "powersource varchar (255) , " +
                        "brand varchar(255) ," +
                        "model varchar (255)," +
                        "screensize varchar(255) ," +
                        "qualityresolution varchar(255) ," +
                        "basket_tv_id int,"+
                        "primary key (id)" +
                        "FOREIGN KEY (basket_tv_id) REFERENCES basket(id)," +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createTvTable);
    }


}