package com.maktab74.domain;

public class Radio extends ElectricalAppliances {
    private String waveRange;
    private Basket basket;



    public Radio() {

    }

    public Radio(int id, int unit, int price, String powerSource, String brand, String model, String waveRange, Basket basket) {
        super(id, unit, price, powerSource, brand, model);
        this.waveRange = waveRange;
        this.basket = basket;
    }

    public String getWaveRange() {
        return waveRange;
    }

    public void setWaveRange(String waveRange) {
        this.waveRange = waveRange;
    }
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
