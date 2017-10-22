package com.model;

import java.util.Date;
import java.util.List;

public class BrickseekSearchResults {

    private String productname;
    private String productAmount;
    private String sku;
    private String upc;
    private String brickseekLink;
    private Date lastUpdated;
    private List<BrickseekResults> results;
    public BrickseekSearchResults(){}
    public BrickseekSearchResults(String productname, String productAmount, String sku, String upc, String brickseekLink, Date lastUpdated, List<BrickseekResults> results) {
        this.productname = productname;
        this.productAmount = productAmount;
        this.sku = sku;
        this.upc = upc;
        this.brickseekLink = brickseekLink;
        this.lastUpdated = lastUpdated;
        this.results = results;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
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

    public String getBrickseekLink() {
        return brickseekLink;
    }

    public void setBrickseekLink(String brickseekLink) {
        this.brickseekLink = brickseekLink;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<BrickseekResults> getResults() {
        return results;
    }

    public void setResults(List<BrickseekResults> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "BrickseekSearchResults{" +
                "productname='" + productname + '\'' +
                ", productAmount='" + productAmount + '\'' +
                ", sku='" + sku + '\'' +
                ", upc='" + upc + '\'' +
                ", brickseekLink='" + brickseekLink + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", results=" + results +
                '}';
    }
}
