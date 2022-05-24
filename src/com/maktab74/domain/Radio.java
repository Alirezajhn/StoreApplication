package com.maktab74.domain;

public class Radio extends ElectricalAppliances{
    private String waveRange;

    public Radio(int id, int unit, int price, String powerSource, String brand, String model, String waveRange) {
        super(id, unit, price, powerSource, brand, model);
        this.waveRange = waveRange;
    }

    public String getWaveRange() {
        return waveRange;
    }

    public void setWaveRange(String waveRange) {
        this.waveRange = waveRange;
    }
}
