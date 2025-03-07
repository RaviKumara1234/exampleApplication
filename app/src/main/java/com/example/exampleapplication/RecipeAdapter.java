package com.example.exampleapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    private Context context;
    private List<Recipe> recipeList;

    public RecipeAdapter(Context context, List<Recipe> recipeList) {
        this.context = context;
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recipe, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.recipeName.setText(recipe.getName());

        if (recipe.getImageResId() != 0) {
            holder.recipeImage.setImageResource(recipe.getImageResId()); // Load image from drawable
        } else {
            holder.recipeImage.setImageResource(android.R.drawable.ic_menu_gallery); // Default Android icon
        }
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView recipeName;
        ImageView recipeImage;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.recipeName);
            recipeImage = itemView.findViewById(R.id.recipeImage);
        }
    }
}
