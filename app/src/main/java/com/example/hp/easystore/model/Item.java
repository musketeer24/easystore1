package com.example.hp.easystore.model;

/**
 * Created by hp on 20-Jun-17.
 */

public class Item {
    public String itemName;
    public Double itemPrice;

    public Item(String x,Double y){
        this.itemName=x;
        this.itemPrice=y;
    }
    public String getItemName(){return itemName;}

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
