package com.akoteng.pizzaapp.classes;


import android.graphics.drawable.Drawable;
import android.media.Image;

public class Pizza {

    private String name, image;
    private int price, product_id, restaurant_id;

    public Pizza() {
    }

    public Pizza(String Image, String name) {
        this.image = image;
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductId() {
        return product_id;
    }

    public void setProductId(int productId) {
        this.product_id = product_id;
    }

    public int getRestaurantId() {
        return restaurant_id;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurant_id = restaurant_id;
    }

}
