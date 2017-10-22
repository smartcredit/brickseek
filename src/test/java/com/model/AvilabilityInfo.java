package com.model;

public class AvilabilityInfo {

    private int quantiy;
    private String stockStatus;

    public AvilabilityInfo(){}
    public AvilabilityInfo(int quantiy, String stockStatus) {
        this.quantiy = quantiy;
        this.stockStatus = stockStatus;
    }

    public int getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(int quantiy) {
        this.quantiy = quantiy;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    @Override
    public String toString() {
        return "AvilabilityInfo{" +
                "quantiy=" + quantiy +
                ", stockStatus='" + stockStatus + '\'' +
                '}';
    }
}
