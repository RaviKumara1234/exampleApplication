package com.example.exampleapplication;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PaneerRecipeActivity extends AppCompatActivity {

    private Button addToFavoriteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paneer); // Set the layout for this specific recipe

        // Initialize the "Add to Favorite" button
        addToFavoriteBtn = findViewById(R.id.addToFavoriteBtn);

        // Set up button click listener
        addToFavoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if recipe is already in favorites
                DatabaseHelper dbHelper = new DatabaseHelper(PaneerRecipeActivity.this);
                if (dbHelper.isRecipeFavorite("Paneer Butter Masala")) {
                    Toast.makeText(PaneerRecipeActivity.this, "Already in favorites", Toast.LENGTH_SHORT).show();
                } else {
                    // Add to favorites
                    dbHelper.addFavoriteRecipe("Paneer Butter Masala");
                    Toast.makeText(PaneerRecipeActivity.this, "Added to favorites!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
