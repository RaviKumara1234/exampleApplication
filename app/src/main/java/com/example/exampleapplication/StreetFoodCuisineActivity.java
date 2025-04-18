package com.example.exampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class StreetFoodCuisineActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_food);  // This will load the XML layout for Street Food

        // Set the title for the action bar or toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Street Food");
        }

        // Set up onClickListeners for each ImageView (food item)
        ImageView foodImage1 = findViewById(R.id.foodImage1);
        foodImage1.setOnClickListener(view -> {
            Intent intent = new Intent(StreetFoodCuisineActivity.this, PanipuriRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage2 = findViewById(R.id.foodImage2);
        foodImage2.setOnClickListener(view -> {
            Intent intent = new Intent(StreetFoodCuisineActivity.this, VadapavRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage3 = findViewById(R.id.foodImage3);
        foodImage3.setOnClickListener(view -> {
            Intent intent = new Intent(StreetFoodCuisineActivity.this, PavbhajiRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage4 = findViewById(R.id.foodImage4);
        foodImage4.setOnClickListener(view -> {
            Intent intent = new Intent(StreetFoodCuisineActivity.this, SamosaRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage5 = findViewById(R.id.foodImage5);
        foodImage5.setOnClickListener(view -> {
            Intent intent = new Intent(StreetFoodCuisineActivity.this, ChaatRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage6 = findViewById(R.id.foodImage6);
        foodImage6.setOnClickListener(view -> {
            Intent intent = new Intent(StreetFoodCuisineActivity.this, KebabsRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage7 = findViewById(R.id.foodImage7);
        foodImage7.setOnClickListener(view -> {
            Intent intent = new Intent(StreetFoodCuisineActivity.this, BhelpuriRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage8 = findViewById(R.id.foodImage8);
        foodImage8.setOnClickListener(view -> {
            Intent intent = new Intent(StreetFoodCuisineActivity.this, FrankieRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage9 = findViewById(R.id.foodImage9);
        foodImage9.setOnClickListener(view -> {
            Intent intent = new Intent(StreetFoodCuisineActivity.this, AlootikkiRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage10 = findViewById(R.id.foodImage10);
        foodImage10.setOnClickListener(view -> {
            Intent intent = new Intent(StreetFoodCuisineActivity.this, EggrollRecipeActivity.class);
            startActivity(intent);
        });
    }
}
