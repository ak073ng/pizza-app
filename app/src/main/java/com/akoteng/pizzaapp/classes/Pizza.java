package com.akoteng.pizzaapp.classes;


import android.graphics.drawable.Drawable;
import android.media.Image;

public class Pizza {

    private String name;
    private Drawable image;

    public Pizza() {
    }

    public Pizza(Drawable Image, String name) {
        this.image = image;
        this.name = name;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
