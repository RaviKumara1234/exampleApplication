package com.example.exampleapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KebabsRecipeActivity extends AppCompatActivity {

    private Button addFavoriteButton;
    private DatabaseHelper dbHelper;
    private String recipeName = "Kebabs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kebabs);

        addFavoriteButton = findViewById(R.id.addFavoriteButton);
        dbHelper = new DatabaseHelper(this);

        if (dbHelper.isRecipeFavorite(recipeName)) {
            addFavoriteButton.setText("Remove from Favorites");
        }

        addFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dbHelper.isRecipeFavorite(recipeName)) {
                    dbHelper.removeFavoriteRecipe(recipeName);
                    addFavoriteButton.setText("Add to Favorites");
                    Toast.makeText(KebabsRecipeActivity.this, recipeName + " removed from favorites!", Toast.LENGTH_SHORT).show();
                } else {
                    dbHelper.addFavoriteRecipe(recipeName);
                    addFavoriteButton.setText("Remove from Favorites");
                    Toast.makeText(KebabsRecipeActivity.this, recipeName + " added to favorites!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
