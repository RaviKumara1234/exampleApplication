package com.example.exampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SouthIndianCuisineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south_indian);  // Load the South Indian cuisine layout

        // Set the title for the action bar or toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("South Indian Cuisine");
        }

        // Set up onClickListeners for each ImageView (food item)
        ImageView foodImage1 = findViewById(R.id.foodImage1);  // Appam
        foodImage1.setOnClickListener(view -> {
            Intent intent = new Intent(SouthIndianCuisineActivity.this, AppamRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage2 = findViewById(R.id.foodImage2);  // Cabbage Thoran
        foodImage2.setOnClickListener(view -> {
            Intent intent = new Intent(SouthIndianCuisineActivity.this, CabbageThoranRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage3 = findViewById(R.id.foodImage3);  // Venn Pongal
        foodImage3.setOnClickListener(view -> {
            Intent intent = new Intent(SouthIndianCuisineActivity.this, VennPongalRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage4 = findViewById(R.id.foodImage4);  // Kesaribath
        foodImage4.setOnClickListener(view -> {
            Intent intent = new Intent(SouthIndianCuisineActivity.this, KesaribathRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage5 = findViewById(R.id.foodImage5);  // Rice Roti (Akki Rotti)
        foodImage5.setOnClickListener(view -> {
            Intent intent = new Intent(SouthIndianCuisineActivity.this, RiceRotiRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage6 = findViewById(R.id.foodImage6);  // Lemon Rice (Chitranna)
        foodImage6.setOnClickListener(view -> {
            Intent intent = new Intent(SouthIndianCuisineActivity.this, LemonRiceRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage7 = findViewById(R.id.foodImage7);  // Ragi Mudde
        foodImage7.setOnClickListener(view -> {
            Intent intent = new Intent(SouthIndianCuisineActivity.this, RagiMuddeRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage8 = findViewById(R.id.foodImage8);  // Bisibele Bath
        foodImage8.setOnClickListener(view -> {
            Intent intent = new Intent(SouthIndianCuisineActivity.this, BisibeleBathRecipeActivity.class);
            startActivity(intent);
        });

        ImageView foodImage9 = findViewById(R.id.foodImage9);  // Dosa
        foodImage9.setOnClickListener(view -> {
            Intent intent = new Intent(SouthIndianCuisineActivity.this, DosaRecipeActivity.class);
            startActivity(intent);
        });
    }
}
