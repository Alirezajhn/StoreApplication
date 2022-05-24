package com.maktab74.domain;

public abstract class Product extends Base {
    private int Unit;
    private int Price;

    public Product() {

    }

    public Product(int id, int unit, int price) {
        super(id);
        Unit = unit;
        Price = price;
    }

    public int getUnit() {
        return Unit;
    }

    public void setUnit(int unit) {
        Unit = unit;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
