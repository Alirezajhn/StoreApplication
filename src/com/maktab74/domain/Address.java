package com.maktab74.domain;

public class Address extends Base{
    private String province;
    private String city;
    private String street;
    private String postalCode;

    public Address(int id, String province, String city, String street, String postalCode) {
        super(id);
        this.province = province;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
