package com.maktab74.domain;

public class Tv extends ElectricalAppliances {
    private String screenSize;
    private String qualityResolution;
    private Basket basket;

    //tv(product) to basket : many to one
    public Tv() {

    }

    public Tv(int id, int unit, int price, String powerSource, String brand, String model, String screenSize, String qualityResolution, Basket basket) {
        super(id, unit, price, powerSource, brand, model);
        this.screenSize = screenSize;
        this.qualityResolution = qualityResolution;
        this.basket = basket;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getQualityResolution() {
        return qualityResolution;
    }

    public void setQualityResolution(String qualityResolution) {
        this.qualityResolution = qualityResolution;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
