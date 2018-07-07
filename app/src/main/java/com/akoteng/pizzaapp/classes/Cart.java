package com.akoteng.pizzaapp.classes;


public class Cart {

    protected String name;
    protected int quantity;
    protected Boolean extra_cheese, thicker_crust, added_sauce;

    public Cart() {
    }

    public Cart(String name, int quantity, Boolean extra_cheese, Boolean thicker_crust, Boolean added_sauce) {
        this.name = name;
        this.quantity = quantity;
        this.extra_cheese = extra_cheese;
        this.thicker_crust = thicker_crust;
        this.added_sauce = added_sauce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Boolean needExtraCheese() {
        return extra_cheese;
    }

    public void setExtraCheese(Boolean extra_cheese) {
        this.extra_cheese = extra_cheese;
    }

    public Boolean needThickerCrust() {
        return extra_cheese;
    }

    public void setThickerCrust(Boolean thicker_crust) {
        this.thicker_crust = thicker_crust;
    }

    public Boolean needAddedSauce() {
        return added_sauce;
    }

    public void setAddedSauce(Boolean added_sauce) {
        this.added_sauce = added_sauce;
    }

}
