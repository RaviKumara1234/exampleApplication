package com.example.exampleapplication;

import androidx.annotation.DrawableRes;

public class Recipe {
    private String name;
    @DrawableRes
    private int imageResId;

    public Recipe(String name, @DrawableRes int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
