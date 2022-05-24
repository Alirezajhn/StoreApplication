package com.maktab74.domain;

public  class Shoes extends Product {
    private String sizeShoes;
    private String color;
    private String typeShoes;

    public Shoes(int id, int unit, int price, String sizeShoes, String color, String typeShoes) {
        super(id, unit, price);
        this.sizeShoes = sizeShoes;
        this.color = color;
        this.typeShoes = typeShoes;
    }

    public String getSizeShoes() {
        return sizeShoes;
    }

    public void setSizeShoes(String sizeShoes) {
        this.sizeShoes = sizeShoes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTypeShoes() {
        return typeShoes;
    }

    public void setTypeShoes(String typeShoes) {
        this.typeShoes = typeShoes;
    }
}
