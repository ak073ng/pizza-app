package com.akoteng.pizzaapp.classes;

public class History extends Cart {

    private String date;

    public History() {
    }

    public History(String name, int quantity, Boolean extra_cheese, Boolean thicker_crust, Boolean added_sauce, String date) {
        super.name = name;
        super.quantity = quantity;
        super.extra_cheese = extra_cheese;
        super.thicker_crust = thicker_crust;
        super.added_sauce = added_sauce;
        this.date = date;
    }

    public String getDatePurchased() {
        return date;
    }

    public void setDatePurchased(String date) {
        this.date = date;
    }

}
