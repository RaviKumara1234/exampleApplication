package com.example.exampleapplication;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    private ListView favoritesListView;
    private ArrayList<String> favoriteRecipes;
    private ArrayAdapter<String> adapter;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        favoritesListView = findViewById(R.id.favoritesListView);
        favoriteRecipes = new ArrayList<>();
        dbHelper = new DatabaseHelper(this);

        loadFavorites();

        // Long click to remove item
        favoritesListView.setOnItemLongClickListener((parent, view, position, id) -> {
            String selectedRecipe = favoriteRecipes.get(position);

            new AlertDialog.Builder(FavoritesActivity.this)
                    .setTitle("Remove Favorite")
                    .setMessage("Remove \"" + selectedRecipe + "\" from favorites?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        boolean deleted = dbHelper.removeFavoriteRecipe(selectedRecipe);  // Corrected method name
                        if (deleted) {
                            favoriteRecipes.remove(position);
                            adapter.notifyDataSetChanged();
                            Toast.makeText(FavoritesActivity.this, "Removed from favorites", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(FavoritesActivity.this, "Failed to remove", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();

            return true;
        });
    }

    private void loadFavorites() {
        Cursor cursor = dbHelper.getAllFavoriteRecipes();

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String recipeName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_RECIPE_NAME));
                favoriteRecipes.add(recipeName);
            }
            cursor.close();
        } else {
            Toast.makeText(this, "No favorite recipes found!", Toast.LENGTH_SHORT).show();
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, favoriteRecipes);
        favoritesListView.setAdapter(adapter);
    }
}
