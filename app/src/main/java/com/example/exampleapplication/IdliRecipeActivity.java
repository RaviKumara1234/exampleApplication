package com.example.exampleapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IdliRecipeActivity extends AppCompatActivity {

    private Button addFavoriteButton;
    private DatabaseHelper dbHelper;
    private String recipeName = "Idli";  // Name of the recipe

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idli);

        addFavoriteButton = findViewById(R.id.addFavoriteButton);
        dbHelper = new DatabaseHelper(this);

        // Check if the recipe is already in favorites
        if (dbHelper.isRecipeFavorite(recipeName)) {
            addFavoriteButton.setText("Remove from Favorites");
        }

        // Handle the button click
        addFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dbHelper.isRecipeFavorite(recipeName)) {
                    // Remove from favorites
                    dbHelper.removeFavoriteRecipe(recipeName);
                    addFavoriteButton.setText("Add to Favorites");
                    Toast.makeText(IdliRecipeActivity.this, recipeName + " removed from favorites!", Toast.LENGTH_SHORT).show();
                } else {
                    // Add to favorites
                    dbHelper.addFavoriteRecipe(recipeName);
                    addFavoriteButton.setText("Remove from Favorites");
                    Toast.makeText(IdliRecipeActivity.this, recipeName + " added to favorites!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
