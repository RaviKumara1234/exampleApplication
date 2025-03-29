package com.example.exampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
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

        // Find buttons for food categories
        Button btnNorthIndian = findViewById(R.id.categoryNorthIndian);
        Button btnSouthIndian = findViewById(R.id.categorySouthIndian);
        Button btnStreetFood = findViewById(R.id.categoryStreetFood);
        Button btnNonVegetarian = findViewById(R.id.categoryNonVegetarian);
        Button btnVegetarian = findViewById(R.id.categoryVegetarian);

        // Set click listeners for each category button
        btnNorthIndian.setOnClickListener(v -> navigateToActivity(NorthIndianCuisineActivity.class));
        btnSouthIndian.setOnClickListener(v -> navigateToActivity(SouthIndianCuisineActivity.class));
        btnStreetFood.setOnClickListener(v -> navigateToActivity(StreetFoodCuisineActivity.class));
        btnNonVegetarian.setOnClickListener(v -> navigateToActivity(NonVegetarianCuisineActivity.class));
        btnVegetarian.setOnClickListener(v -> navigateToActivity(VegetarianCuisineActivity.class));
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
