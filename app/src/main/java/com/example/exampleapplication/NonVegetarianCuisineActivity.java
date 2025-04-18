package com.example.exampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class NonVegetarianCuisineActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_vegetarian);  // This will load the XML layout for Non-Vegetarian Cuisine

        // Set the title for the action bar or toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Non-Vegetarian Cuisine");
        }

        // Set up onClickListeners for each ImageView (food item)
        ImageView foodImage1 = findViewById(R.id.foodImage1);
        foodImage1.setOnClickListener(view -> {
            Intent intent = new Intent(NonVegetarianCuisineActivity.this, ChickenTikkaRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage2 = findViewById(R.id.foodImage2);
        foodImage2.setOnClickListener(view -> {
            Intent intent = new Intent(NonVegetarianCuisineActivity.this, ButterChickenRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage3 = findViewById(R.id.foodImage3);
        foodImage3.setOnClickListener(view -> {
            Intent intent = new Intent(NonVegetarianCuisineActivity.this, MuttonKebabRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage4 = findViewById(R.id.foodImage4);
        foodImage4.setOnClickListener(view -> {
            Intent intent = new Intent(NonVegetarianCuisineActivity.this, ChickenShawarmaRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage5 = findViewById(R.id.foodImage5);
        foodImage5.setOnClickListener(view -> {
            Intent intent = new Intent(NonVegetarianCuisineActivity.this, EggCurryRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage6 = findViewById(R.id.foodImage6);
        foodImage6.setOnClickListener(view -> {
            Intent intent = new Intent(NonVegetarianCuisineActivity.this, FishFryRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage7 = findViewById(R.id.foodImage7);
        foodImage7.setOnClickListener(view -> {
            Intent intent = new Intent(NonVegetarianCuisineActivity.this, ChickenSukkaRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage8 = findViewById(R.id.foodImage8);
        foodImage8.setOnClickListener(view -> {
            Intent intent = new Intent(NonVegetarianCuisineActivity.this, TandooriChickenRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage9 = findViewById(R.id.foodImage9);
        foodImage9.setOnClickListener(view -> {
            Intent intent = new Intent(NonVegetarianCuisineActivity.this, BiryaniRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage10 = findViewById(R.id.foodImage10);
        foodImage10.setOnClickListener(view -> {
            Intent intent = new Intent(NonVegetarianCuisineActivity.this, ChickenCurryRecipeActivity.class);
            startActivity(intent);
        });
    }
}
