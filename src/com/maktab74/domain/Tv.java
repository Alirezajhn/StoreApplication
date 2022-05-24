package com.maktab74.domain;

public class Tv extends ElectricalAppliances{
    private String screenSize;
    private String qualityResolution;

    public Tv(int id, int unit, int price, String powerSource, String brand, String model, String screenSize, String qualityResolution) {
        super(id, unit, price, powerSource, brand, model);
        this.screenSize = screenSize;
        this.qualityResolution = qualityResolution;
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
}
