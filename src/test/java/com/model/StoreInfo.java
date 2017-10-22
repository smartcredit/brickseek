package com.model;

public class StoreInfo {

    private String name;
    private String address;
    private String distance;
    public StoreInfo(){}
    public StoreInfo(String name, String address, String distance) {
        this.name = name;
        this.address = address;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "StoreInfo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
