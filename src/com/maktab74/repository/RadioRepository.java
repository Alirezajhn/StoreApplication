package com.maktab74.repository;

import com.maktab74.domain.Radio;

import java.sql.*;
import java.util.ArrayList;

public class RadioRepository {
    private Connection connection;

    public RadioRepository(Connection connection) {
        this.connection = connection;
    }

    //radio(product) to basket : many to one
    private ArrayList<Radio> radios = new ArrayList<>();

    public ArrayList<Radio> getAllRadio() throws SQLException {
        String query =
                "select * from radio";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Radio radio = new Radio();
            radio.setId(resultSet.getInt(1));
            radio.setUnit(resultSet.getInt(2));
            radio.setPrice(resultSet.getInt(3));
            radio.setPowerSource(resultSet.getString(4));
            radio.setPowerSource(resultSet.getString(5));
            radio.setBrand(resultSet.getString(6));
            radio.setModel(resultSet.getString(7));
            radio.setWaveRange(resultSet.getString(8));
            radios.add(radio);
        }
        return radios;
    }

//    public Radio[] getAllByProductBaseId(int basketId) throws SQLException {
//        int countAll = countAllByProductBaseId(basketId);
//        if (countAll > 0) {
//            Radio[] radios = new Radio[countAll];
//            int emptyIndex = 0;
//
//            String query =
//                    "select * from radio as r join basket as b " +
//                            "on r.basket_radio_id = b.product_id " +
//                            "where basket_radio_id = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1, basketId);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//               radios[emptyIndex] =
//                        new Radio(
//                                resultSet.getInt(1),
//                                resultSet.getInt(2),
//                                resultSet.getInt(3),
//                                resultSet.getString(4),
//                                resultSet.getString(5),
//                                resultSet.getString(6),
//                                resultSet.getString(7),
//                                new Basket(
//                                        resultSet.getInt(9),
//                                        resultSet.getInt(10),
//                                        resultSet.getInt(11),
//                                        resultSet.getInt(12),
//                                        resultSet.getString(13)
//                                )
//                        );
//                emptyIndex++;
//            }
//            return radios;
//        } else {
//            return new Radio[0];
//        }
//
//    }

       /* public int countAllByProductBaseId ( int basketId) throws SQLException {
            String query = "select count(*) from tv where basket_radio_id= ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, basketId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return 0;
        }*/
        public Radio insert (Radio radio) throws SQLException {
            String insertQuery = "insert into user(" +
                    "unit, price ,powersource , brand , model, waverange, basket_radio_id" +
                    ") values (? , ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, radio.getUnit());
            preparedStatement.setInt(2, radio.getPrice());
            preparedStatement.setString(3, radio.getPowerSource());
            preparedStatement.setString(4, radio.getBrand());
            preparedStatement.setString(5, radio.getModel());
            preparedStatement.setString(6, radio.getWaveRange());
            preparedStatement.executeUpdate();
            radio.setId(getMaxId());

            return radio;
        }

        public int getMaxId () throws SQLException {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select max(id) from radio");
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return 0;
        }
    }

