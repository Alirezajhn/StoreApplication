package com.maktab74.domain;

public abstract class ElectricalAppliances extends Product {
    private String powerSource;
    private String brand;
    private String model;

    public ElectricalAppliances() {

    }

    public ElectricalAppliances(int id, int unit, int price, String powerSource, String brand, String model) {
        super(id, unit, price);
        this.powerSource = powerSource;
        this.brand = brand;
        this.model = model;
    }

    public String getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
