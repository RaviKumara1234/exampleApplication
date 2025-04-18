package com.example.exampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

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

        // All recipe names
        String[] allRecipes = {
                // North Indian
                "Idli", "Paneer Butter Masala", "Chole Bhature", "Jeera Rice",
                "Naan", "Palak Paneer", "Dhokla", "Veg Biryani","Kheer","Tandoori",

                // South Indian
                 "Appam", "Cabbage Thoran", "Venn Pongal", "Kesaribath",
                "Rice Roti", "Lemon Rice", "Ragi Mudde", "Bisibele Bath", "Dosa",

                // Street Food
                "Panipuri", "Vadapav", "Pavbhaji", "Samosa", "Chaat",
                "Kebabs", "Bhelpuri", "Frankie", "Alootikki", "Eggroll",

                // Non-Vegetarian
                "Chicken Tikka", "Mutton Kebab", "Chicken Shawarma","Butter Chicken", "Tandoori Chicken",
                "Egg Curry", "Fish Fry", "Chicken Sukka", "Biryani", "Chicken Curry"
        };

        // Set up adapter to show suggestions
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, allRecipes);
        searchRecipe.setAdapter(adapter);

        // Set category button actions
        btnNorthIndian.setOnClickListener(v -> navigateToActivity(NorthIndianCuisineActivity.class));
        btnSouthIndian.setOnClickListener(v -> navigateToActivity(SouthIndianCuisineActivity.class));
        btnStreetFood.setOnClickListener(v -> navigateToActivity(StreetFoodCuisineActivity.class));
        btnNonVegetarian.setOnClickListener(v -> navigateToActivity(NonVegetarianCuisineActivity.class));

        // Handle item click in search
        searchRecipe.setOnItemClickListener((parent, view, position, id) -> {
            String selectedRecipe = (String) parent.getItemAtPosition(position);
            handleRecipeSelection(selectedRecipe);
        });
    }

    // Navigate to corresponding recipe activity
    private void handleRecipeSelection(String selectedRecipe) {
        Intent intent;
        switch (selectedRecipe) {
            // North Indian
            case "Idli":
                intent = new Intent(this, IdliRecipeActivity.class);
                break;
            case "Kheer":
                intent = new Intent(this, KheerRecipeActivity.class);
                break;
            case "Paneer Butter Masala":
                intent = new Intent(this, PaneerRecipeActivity.class);
                break;
            case "Chole Bhature":
                intent = new Intent(this, CholeRecipeActivity.class);
                break;
            case "Jeera Rice":
                intent = new Intent(this, JeeraRiceRecipeActivity.class);
                break;
            case "Tandoori":
                intent = new Intent(this, TandooriRecipeActivity.class);
                break;
            case "Naan":
                intent = new Intent(this, NaanRecipeActivity.class);
                break;
            case "Palak Paneer":
                intent = new Intent(this, PalakPaneerRecipeActivity.class);
                break;
            case "Dhokla":
                intent = new Intent(this, DhoklaRecipeActivity.class);
                break;
            case "Veg Biryani":
                intent = new Intent(this, VegBiriyaniRecipeActivity.class);
                break;

            // South Indian

            case "Appam":
                intent = new Intent(this, AppamRecipeActivity.class);
                break;
            case "Cabbage Thoran":
                intent = new Intent(this, CabbageThoranRecipeActivity.class);
                break;
            case "Venn Pongal":
                intent = new Intent(this, VennPongalRecipeActivity.class);
                break;
            case "Kesaribath":
                intent = new Intent(this, KesaribathRecipeActivity.class);
                break;
            case "Rice Roti":
                intent = new Intent(this, RiceRotiRecipeActivity.class);
                break;
            case "Lemon Rice":
                intent = new Intent(this, LemonRiceRecipeActivity.class);
                break;
            case "Ragi Mudde":
                intent = new Intent(this, RagiMuddeRecipeActivity.class);
                break;
            case "Bisibele Bath":
                intent = new Intent(this, BisibeleBathRecipeActivity.class);
                break;
            case "Dosa":
                intent = new Intent(this, DosaRecipeActivity.class);
                break;

            // Street Food
            case "Panipuri":
                intent = new Intent(this, PanipuriRecipeActivity.class);
                break;
            case "Vadapav":
                intent = new Intent(this, VadapavRecipeActivity.class);
                break;
            case "Pavbhaji":
                intent = new Intent(this, PavbhajiRecipeActivity.class);
                break;
            case "Samosa":
                intent = new Intent(this, SamosaRecipeActivity.class);
                break;
            case "Chaat":
                intent = new Intent(this, ChaatRecipeActivity.class);
                break;
            case "Kebabs":
                intent = new Intent(this, KebabsRecipeActivity.class);
                break;
            case "Bhelpuri":
                intent = new Intent(this, BhelpuriRecipeActivity.class);
                break;
            case "Frankie":
                intent = new Intent(this, FrankieRecipeActivity.class);
                break;
            case "Alootikki":
                intent = new Intent(this, AlootikkiRecipeActivity.class);
                break;
            case "Eggroll":
                intent = new Intent(this, EggrollRecipeActivity.class);
                break;

            // Non-Vegetarian
            case "Chicken Tikka":
                intent = new Intent(this, ChickenTikkaRecipeActivity.class);
                break;
            case "Mutton Kebab":
                intent = new Intent(this, MuttonKebabRecipeActivity.class);
                break;
            case "Chicken Shawarma":
                intent = new Intent(this, ChickenShawarmaRecipeActivity.class);
                break;
            case "Egg Curry":
                intent = new Intent(this, EggCurryRecipeActivity.class);
                break;
            case "Fish Fry":
                intent = new Intent(this, FishFryRecipeActivity.class);
                break;
            case "Chicken Sukka":
                intent = new Intent(this, ChickenSukkaRecipeActivity.class);
                break;
            case "Biryani":
                intent = new Intent(this, BiryaniRecipeActivity.class);
                break;
            case "Chicken Curry":
                intent = new Intent(this, ChickenCurryRecipeActivity.class);
                break;
            case "Butter Chicken":
                intent = new Intent(this, ButterChickenRecipeActivity.class);
                break;
            case "Tandoori Chicken":
                intent = new Intent(this, TandooriChickenRecipeActivity.class);
                break;

            default:
                Toast.makeText(this, "Recipe not found!", Toast.LENGTH_SHORT).show();
                return;
        }
        startActivity(intent);
    }

    private void navigateToActivity(Class<?> targetActivity) {
        Intent intent = new Intent(this, targetActivity);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (id == R.id.action_profile) {
            String username = getIntent().getStringExtra("USERNAME");
            String phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");
            String address = getIntent().getStringExtra("ADDRESS");

            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("USERNAME", username);
            intent.putExtra("PHONE_NUMBER", phoneNumber);
            intent.putExtra("ADDRESS", address);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_logout) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
