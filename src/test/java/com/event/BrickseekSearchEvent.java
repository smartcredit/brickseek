package com.event;

import com.model.BrickseekSearchResults;

public class BrickseekSearchEvent {

    private String sku;
    private String upc;
    private String zip;
    private String searchBy;
    private BrickseekSearchResults searchResult;

    public BrickseekSearchEvent(){}
    public BrickseekSearchEvent(String sku, String upc, String zip, String searchBy, BrickseekSearchResults searchResult) {
        this.sku = sku;
        this.upc = upc;
        this.zip = zip;
        this.searchBy = searchBy;
        this.searchResult = searchResult;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public BrickseekSearchResults getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(BrickseekSearchResults searchResult) {
        this.searchResult = searchResult;
    }

    @Override
    public String toString() {
        return "BrickseekSearchEvent{" +
                "sku='" + sku + '\'' +
                ", upc='" + upc + '\'' +
                ", zip='" + zip + '\'' +
                ", searchBy='" + searchBy + '\'' +
                ", searchResult=" + searchResult +
                '}';
    }
}
