package com.model;

public class BrickseekResults {

    private StoreInfo storeInfo;
    private AvilabilityInfo avilabilityInfo;
    private PriceInfo priceInfo;
    public BrickseekResults(){}
    public BrickseekResults(StoreInfo storeInfo, AvilabilityInfo avilabilityInfo, PriceInfo priceInfo) {
        this.storeInfo = storeInfo;
        this.avilabilityInfo = avilabilityInfo;
        this.priceInfo = priceInfo;
    }

    public StoreInfo getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(StoreInfo storeInfo) {
        this.storeInfo = storeInfo;
    }

    public AvilabilityInfo getAvilabilityInfo() {
        return avilabilityInfo;
    }

    public void setAvilabilityInfo(AvilabilityInfo avilabilityInfo) {
        this.avilabilityInfo = avilabilityInfo;
    }

    public PriceInfo getPriceInfo() {
        return priceInfo;
    }

    public void setPriceInfo(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public String toString() {
        return "BrickseekResults{" +
                "storeInfo=" + storeInfo +
                ", avilabilityInfo=" + avilabilityInfo +
                ", priceInfo=" + priceInfo +
                '}';
    }
}
