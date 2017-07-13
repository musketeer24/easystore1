package com.example.hp.easystore.subcategoryfragment.GroceryController;

/**
 * Created by hp on 24-Jun-17.
 */

public class GroceryPojo {
    private String groceryBusinessName, groceryContactNumber, grocerLocation, groceryDescription;

    public GroceryPojo(String groceryBusinessName, String groceryContactNumber, String grocerLocation, String groceryDescription) {
        this.groceryBusinessName = groceryBusinessName;
        this.groceryContactNumber = groceryContactNumber;
        this.grocerLocation = grocerLocation;
        this.groceryDescription = groceryDescription;
    }

    public String getGroceryBusinessName() {
        return groceryBusinessName;
    }

    public void setGroceryBusinessName(String groceryBusinessName) {
        this.groceryBusinessName = groceryBusinessName;
    }

    public String getGroceryContactNumber() {
        return groceryContactNumber;
    }

    public void setGroceryContactNumber(String groceryContactNumber) {
        this.groceryContactNumber = groceryContactNumber;
    }

    public String getGrocerLocation() {
        return grocerLocation;
    }

    public void setGrocerLocation(String grocerLocation) {
        this.grocerLocation = grocerLocation;
    }

    public String getGroceryDescription() {
        return groceryDescription;
    }

    public void setGroceryDescription(String groceryDescription) {
        this.groceryDescription = groceryDescription;
    }

}
