package com.example.exampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView bestRecipesRecycler, recommendedRecipesRecycler;
    private RecipeAdapter bestRecipesAdapter, recommendedRecipesAdapter;
    private List<Recipe> bestRecipesList, recommendedRecipesList;
    private TextView usernameDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Get the username from intent
        String username = getIntent().getStringExtra("USERNAME");

        // Find UI components
        usernameDisplay = findViewById(R.id.usernameDisplay);
        bestRecipesRecycler = findViewById(R.id.bestRecipesRecycler);
        recommendedRecipesRecycler = findViewById(R.id.recommendedRecipesRecycler);
        Button searchButton = findViewById(R.id.searchButton);

        // Set username in TextView
        if (username != null) {
            usernameDisplay.setText("Welcome, " + username + "!");
        }

        // Load Best Indian Recipes
        bestRecipesList = new ArrayList<>();
        bestRecipesList.add(new Recipe("Chicken Biryani", R.drawable.chicken));
        bestRecipesList.add(new Recipe("Paneer Butter Masala", R.drawable.download));

        // Load Recommended Indian Recipes
        recommendedRecipesList = new ArrayList<>();
        recommendedRecipesList.add(new Recipe("Idli Sambar", R.drawable.idli));
        recommendedRecipesList.add(new Recipe("Lemon Rice", R.drawable.download));

        // Setup RecyclerViews
        bestRecipesAdapter = new RecipeAdapter(this, bestRecipesList);
        bestRecipesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        bestRecipesRecycler.setAdapter(bestRecipesAdapter);

        recommendedRecipesAdapter = new RecipeAdapter(this, recommendedRecipesList);
        recommendedRecipesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recommendedRecipesRecycler.setAdapter(recommendedRecipesAdapter);

        // Search Button Click
        searchButton.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, SearchActivity.class)));
    }
}
