package com.example.exampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ThirdActivity extends AppCompatActivity {

    private AutoCompleteTextView searchRecipe;

    private final String[] allRecipes = {
            // North Indian
            "Idli", "Paneer Butter Masala", "Chole Bhature", "Jeera Rice",
            "Naan", "Palak Paneer", "Dhokla", "Veg Biryani", "Kheer", "Tandoori",

            // South Indian
            "Appam", "Cabbage Thoran", "Venn Pongal", "Kesaribath",
            "Rice Roti", "Lemon Rice", "Ragi Mudde", "Bisibele Bath", "Dosa",

            // Street Food
            "Panipuri", "Vadapav", "Pavbhaji", "Samosa", "Chaat",
            "Kebabs", "Bhelpuri", "Frankie", "Alootikki", "Eggroll",

            // Non-Vegetarian
            "Chicken Tikka", "Mutton Kebab", "Chicken Shawarma", "Butter Chicken",
            "Tandoori Chicken", "Egg Curry", "Fish Fry", "Chicken Sukka",
            "Biryani", "Chicken Curry"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnNorthIndian = findViewById(R.id.categoryNorthIndian);
        Button btnSouthIndian = findViewById(R.id.categorySouthIndian);
        Button btnStreetFood = findViewById(R.id.categoryStreetFood);
        Button btnNonVegetarian = findViewById(R.id.categoryNonVegetarian);
        Button viewFavoritesButton = findViewById(R.id.viewFavoritesButton); // Added favorites button

        searchRecipe = findViewById(R.id.searchRecipe);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, allRecipes);
        searchRecipe.setAdapter(adapter);

        // Clear icon inside AutoCompleteTextView
        searchRecipe.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;
            if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                if (searchRecipe.getCompoundDrawables()[DRAWABLE_RIGHT] != null &&
                        event.getRawX() >= (searchRecipe.getRight() - searchRecipe.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width() - searchRecipe.getPaddingEnd())) {
                    searchRecipe.setText("");
                    return true;
                }
            }
            return false;
        });

        // Handle dropdown item click
        searchRecipe.setOnItemClickListener((parent, view, position, id) -> {
            String selectedRecipe = (String) parent.getItemAtPosition(position);
            handleRecipeSelection(selectedRecipe);
        });

        // Handle Enter key (Done/Search)
        searchRecipe.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH ||
                    (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)) {

                String input = searchRecipe.getText().toString().trim();
                boolean found = false;

                for (String recipe : allRecipes) {
                    if (recipe.equalsIgnoreCase(input)) {
                        found = true;
                        handleRecipeSelection(recipe);
                        break;
                    }
                }

                if (!found && !input.isEmpty()) {
                    Toast.makeText(this, "Recipe not found. Please try another.", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
            return false;
        });

        // Category button navigation
        btnNorthIndian.setOnClickListener(v -> navigateToActivity(NorthIndianCuisineActivity.class));
        btnSouthIndian.setOnClickListener(v -> navigateToActivity(SouthIndianCuisineActivity.class));
        btnStreetFood.setOnClickListener(v -> navigateToActivity(StreetFoodCuisineActivity.class));
        btnNonVegetarian.setOnClickListener(v -> navigateToActivity(NonVegetarianCuisineActivity.class));

        // ✅ View Favorites button click
        viewFavoritesButton.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, FavoritesActivity.class);
            startActivity(intent);
        });
    }

    private void handleRecipeSelection(String selectedRecipe) {
        Intent intent;
        switch (selectedRecipe) {
            case "Idli": intent = new Intent(this, IdliRecipeActivity.class); break;
            case "Kheer": intent = new Intent(this, KheerRecipeActivity.class); break;
            case "Paneer Butter Masala": intent = new Intent(this, PaneerRecipeActivity.class); break;
            case "Chole Bhature": intent = new Intent(this, CholeRecipeActivity.class); break;
            case "Jeera Rice": intent = new Intent(this, JeeraRiceRecipeActivity.class); break;
            case "Tandoori": intent = new Intent(this, TandooriRecipeActivity.class); break;
            case "Naan": intent = new Intent(this, NaanRecipeActivity.class); break;
            case "Palak Paneer": intent = new Intent(this, PalakPaneerRecipeActivity.class); break;
            case "Dhokla": intent = new Intent(this, DhoklaRecipeActivity.class); break;
            case "Veg Biryani": intent = new Intent(this, VegBiriyaniRecipeActivity.class); break;

            case "Appam": intent = new Intent(this, AppamRecipeActivity.class); break;
            case "Cabbage Thoran": intent = new Intent(this, CabbageThoranRecipeActivity.class); break;
            case "Venn Pongal": intent = new Intent(this, VennPongalRecipeActivity.class); break;
            case "Kesaribath": intent = new Intent(this, KesaribathRecipeActivity.class); break;
            case "Rice Roti": intent = new Intent(this, RiceRotiRecipeActivity.class); break;
            case "Lemon Rice": intent = new Intent(this, LemonRiceRecipeActivity.class); break;
            case "Ragi Mudde": intent = new Intent(this, RagiMuddeRecipeActivity.class); break;
            case "Bisibele Bath": intent = new Intent(this, BisibeleBathRecipeActivity.class); break;
            case "Dosa": intent = new Intent(this, DosaRecipeActivity.class); break;

            case "Panipuri": intent = new Intent(this, PanipuriRecipeActivity.class); break;
            case "Vadapav": intent = new Intent(this, VadapavRecipeActivity.class); break;
            case "Pavbhaji": intent = new Intent(this, PavbhajiRecipeActivity.class); break;
            case "Samosa": intent = new Intent(this, SamosaRecipeActivity.class); break;
            case "Chaat": intent = new Intent(this, ChaatRecipeActivity.class); break;
            case "Kebabs": intent = new Intent(this, KebabsRecipeActivity.class); break;
            case "Bhelpuri": intent = new Intent(this, BhelpuriRecipeActivity.class); break;
            case "Frankie": intent = new Intent(this, FrankieRecipeActivity.class); break;
            case "Alootikki": intent = new Intent(this, AlootikkiRecipeActivity.class); break;
            case "Eggroll": intent = new Intent(this, EggrollRecipeActivity.class); break;

            case "Chicken Tikka": intent = new Intent(this, ChickenTikkaRecipeActivity.class); break;
            case "Mutton Kebab": intent = new Intent(this, MuttonKebabRecipeActivity.class); break;
            case "Chicken Shawarma": intent = new Intent(this, ChickenShawarmaRecipeActivity.class); break;
            case "Egg Curry": intent = new Intent(this, EggCurryRecipeActivity.class); break;
            case "Fish Fry": intent = new Intent(this, FishFryRecipeActivity.class); break;
            case "Chicken Sukka": intent = new Intent(this, ChickenSukkaRecipeActivity.class); break;
            case "Biryani": intent = new Intent(this, BiryaniRecipeActivity.class); break;
            case "Chicken Curry": intent = new Intent(this, ChickenCurryRecipeActivity.class); break;
            case "Butter Chicken": intent = new Intent(this, ButterChickenRecipeActivity.class); break;
            case "Tandoori Chicken": intent = new Intent(this, TandooriChickenRecipeActivity.class); break;

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
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
            intent.putExtra("PHONE_NUMBER", getIntent().getStringExtra("PHONE_NUMBER"));
            intent.putExtra("ADDRESS", getIntent().getStringExtra("ADDRESS"));
            startActivity(intent);
            return true;
        } else if (id == R.id.action_logout) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
