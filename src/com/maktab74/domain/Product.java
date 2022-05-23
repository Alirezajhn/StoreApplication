package com.maktab74.domain;

public abstract class Product extends Base{
    private int Unit;
    private int Price;

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
