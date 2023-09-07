package com.example.JUnit_Example.models;

public class Address {

    String city;
    String Country;
    String address;
    int pincode;
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return Country;
    }
    public void setCountry(String country) {
        Country = country;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getPincode() {
        return pincode;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", Country='" + Country + '\'' +
                ", address='" + address + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
