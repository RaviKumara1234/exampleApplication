package com.example.exampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class NorthIndianCuisineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_indian); // Make sure this is the correct layout file

        // Set the title for the action bar or toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("North Indian Cuisine");
        }

        // Set up onClickListeners for each ImageView (food item)
        ImageView foodImage1 = findViewById(R.id.foodImage1);
        foodImage1.setOnClickListener(view -> {
            Intent intent = new Intent(NorthIndianCuisineActivity.this, IdliRecipeActivity.class);
            startActivity(intent);
        });

       /* ImageView foodImage2 = findViewById(R.id.foodImage2);
        foodImage2.setOnClickListener(view -> {
            Intent intent = new Intent(NorthIndianCuisineActivity.this, CholeRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage3 = findViewById(R.id.foodImage3);
        foodImage3.setOnClickListener(view -> {
            Intent intent = new Intent(NorthIndianCuisineActivity.this, JeeraRiceRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage4 = findViewById(R.id.foodImage4);
        foodImage4.setOnClickListener(view -> {
            Intent intent = new Intent(NorthIndianCuisineActivity.this, KheerRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage5 = findViewById(R.id.foodImage5);
        foodImage5.setOnClickListener(view -> {
            Intent intent = new Intent(NorthIndianCuisineActivity.this, PalakPaneerRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage6 = findViewById(R.id.foodImage6);
        foodImage6.setOnClickListener(view -> {
            Intent intent = new Intent(NorthIndianCuisineActivity.this, NaanRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage7 = findViewById(R.id.foodImage7);
        foodImage7.setOnClickListener(view -> {
            Intent intent = new Intent(NorthIndianCuisineActivity.this, PaneerRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage8 = findViewById(R.id.foodImage8);
        foodImage8.setOnClickListener(view -> {
            Intent intent = new Intent(NorthIndianCuisineActivity.this, TandooriRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage9 = findViewById(R.id.foodImage9);
        foodImage9.setOnClickListener(view -> {
            Intent intent = new Intent(NorthIndianCuisineActivity.this, VegBiriyaniRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage10 = findViewById(R.id.foodImage10);
        foodImage10.setOnClickListener(view -> {
            Intent intent = new Intent(NorthIndianCuisineActivity.this, DhoklaRecipeActivity.class);
            startActivity(intent);
        });*/
    }
}
