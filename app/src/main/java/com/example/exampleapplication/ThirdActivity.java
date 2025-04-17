package com.example.exampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ThirdActivity extends AppCompatActivity {

    private AutoCompleteTextView searchRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Setup the Toolbar for menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find buttons for food categories
        Button btnNorthIndian = findViewById(R.id.categoryNorthIndian);
        Button btnSouthIndian = findViewById(R.id.categorySouthIndian);
        Button btnStreetFood = findViewById(R.id.categoryStreetFood);
        Button btnNonVegetarian = findViewById(R.id.categoryNonVegetarian);

        // Initialize AutoCompleteTextView for recipe search
        searchRecipe = findViewById(R.id.searchRecipe);

        // Recipe suggestions for each category (North Indian, South Indian, etc.)
        String[] northIndianRecipes = {
                "Butter Chicken", "Paneer Butter Masala", "Chole Bhature",
                "Jeera Rice", "Tandoori Chicken", "Naan", "Palak Paneer",
                "Dhokla", "Veg Biryani"
        };

        // Combine all recipes into one list (you can extend this with other cuisines as well)
        String[] allRecipes = new String[northIndianRecipes.length];
        System.arraycopy(northIndianRecipes, 0, allRecipes, 0, northIndianRecipes.length);

        // Set up adapter to show suggestions for recipes
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, allRecipes);
        searchRecipe.setAdapter(adapter);

        // Set click listeners for each category button
        btnNorthIndian.setOnClickListener(v -> navigateToActivity(NorthIndianCuisineActivity.class));
        btnSouthIndian.setOnClickListener(v -> navigateToActivity(SouthIndianCuisineActivity.class));
        btnStreetFood.setOnClickListener(v -> navigateToActivity(StreetFoodCuisineActivity.class));
        btnNonVegetarian.setOnClickListener(v -> navigateToActivity(NonVegetarianCuisineActivity.class));

        // Set up listener for AutoCompleteTextView search
        searchRecipe.setOnItemClickListener((parent, view, position, id) -> {
            String selectedRecipe = (String) parent.getItemAtPosition(position);
            handleRecipeSelection(selectedRecipe);
        });
    }

    // Handle recipe selection after search
    private void handleRecipeSelection(String selectedRecipe) {
        Intent intent;
        switch (selectedRecipe) {
            case "Idli":
                intent = new Intent(ThirdActivity.this, IdliRecipeActivity.class);
                break;
            case "Paneer Butter Masala":
                intent = new Intent(ThirdActivity.this, PaneerRecipeActivity.class);
                break;
            case "Chole Bhature":
                intent = new Intent(ThirdActivity.this, CholeRecipeActivity.class);
                break;
            case "Jeera Rice":
                intent = new Intent(ThirdActivity.this, JeeraRiceRecipeActivity.class);
                break;
            case "Tandoori Chicken":
                intent = new Intent(ThirdActivity.this, TandooriRecipeActivity.class);
                break;
            case "Naan":
                intent = new Intent(ThirdActivity.this, NaanRecipeActivity.class);
                break;
            case "Palak Paneer":
                intent = new Intent(ThirdActivity.this, PalakPaneerRecipeActivity.class);
                break;
            case "Dhokla":
                intent = new Intent(ThirdActivity.this, DhoklaRecipeActivity.class);
                break;
            case "Veg Biryani":
                intent = new Intent(ThirdActivity.this, VegBiriyaniRecipeActivity.class);
                break;
            default:
                intent = new Intent(ThirdActivity.this, IdliRecipeActivity.class);  // Fallback
                break;
        }
        startActivity(intent);
    }

    // Method to handle activity navigation
    private void navigateToActivity(Class<?> targetActivity) {
        Intent intent = new Intent(ThirdActivity.this, targetActivity);
        startActivity(intent);
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
            // Retrieve user data passed to ThirdActivity
            String username = getIntent().getStringExtra("USERNAME");
            String phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");
            String address = getIntent().getStringExtra("ADDRESS");

            // Create an Intent to navigate to ProfileActivity
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("USERNAME", username);  // Pass username to ProfileActivity
            intent.putExtra("PHONE_NUMBER", phoneNumber);  // Pass phone number to ProfileActivity
            intent.putExtra("ADDRESS", address);  // Pass address to ProfileActivity
            startActivity(intent);  // Start ProfileActivity
            return true;
        } else if (id == R.id.action_logout) {
            finish(); // Close this activity (logout)
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
