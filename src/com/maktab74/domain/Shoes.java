package com.maktab74.domain;

public  class Shoes extends Product {
    private String sizeShoes;
    private String color;
    private String typeShoes;

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
