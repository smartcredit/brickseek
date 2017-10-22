package com.model;

public class PriceInfo {
    private String amount;
    private String comments;
    public PriceInfo(){}
    public PriceInfo(String amount, String comments) {
        this.amount = amount;
        this.comments = comments;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "PriceInfo{" +
                "amount='" + amount + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
