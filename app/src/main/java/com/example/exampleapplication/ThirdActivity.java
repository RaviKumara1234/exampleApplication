package com.example.exampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Setup the Toolbar for menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get username from intent
        String username = getIntent().getStringExtra("USERNAME");

        // Display username
        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome, " + username + " to our App!");

        // Find buttons for food categories
        Button btnNorthIndian = findViewById(R.id.categoryNorthIndian);
        Button btnSouthIndian = findViewById(R.id.categorySouthIndian);
        Button btnStreetFood = findViewById(R.id.categoryStreetFood);
        Button btnNonVegetarian = findViewById(R.id.categoryNonVegetarian);
        Button btnVegetarian = findViewById(R.id.categoryVegetarian);

        // Set click listeners for each category button
        btnNorthIndian.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, FoodDetailsActivity.class);
            intent.putExtra("CATEGORY", "North Indian");
            startActivity(intent);
        });

        btnSouthIndian.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, FoodDetailsActivity.class);
            intent.putExtra("CATEGORY", "South Indian");
            startActivity(intent);
        });

        btnStreetFood.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, FoodDetailsActivity.class);
            intent.putExtra("CATEGORY", "Street Food");
            startActivity(intent);
        });

        btnNonVegetarian.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, FoodDetailsActivity.class);
            intent.putExtra("CATEGORY", "Non-Vegetarian");
            startActivity(intent);
        });

        btnVegetarian.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, FoodDetailsActivity.class);
            intent.putExtra("CATEGORY", "Vegetarian");
            startActivity(intent);
        });
    }

    // Load the menu properly
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu); // Inflate the menu
        return true;
    }

    // Handle menu item selection
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId(); // Get selected item ID

        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (id == R.id.action_profile) {
            startActivity(new Intent(this, ProfileActivity.class));
            return true;
        } else if (id == R.id.action_logout) {
            finish(); // Close this activity (logout)
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
