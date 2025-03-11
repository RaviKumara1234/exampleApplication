package com.example.exampleapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NorthIndianCuisineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_indian); // Make sure this is the correct layout file

        // Set the title for the action bar or toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("North Indian Cuisine");
        }

        // Set the dynamic title in the layout (optional as it's already set in XML)
        TextView cuisineTitle = findViewById(R.id.cuisineTitle);
        cuisineTitle.setText("North Indian Cuisine");

        // Set images dynamically using setImageResource()
        ImageView foodImage1 = findViewById(R.id.foodImage1);
        foodImage1.setImageResource(R.drawable.idli); // Replace with actual image resource

        ImageView foodImage2 = findViewById(R.id.foodImage2);
        foodImage2.setImageResource(R.drawable.chole); // Replace with actual image resource

        ImageView foodImage3 = findViewById(R.id.foodImage3);
        foodImage3.setImageResource(R.drawable.jeerarice); // Replace with actual image resource

        ImageView foodImage4 = findViewById(R.id.foodImage4);
        foodImage4.setImageResource(R.drawable.kheer); // Replace with actual image resource

        ImageView foodImage5 = findViewById(R.id.foodImage5);
        foodImage5.setImageResource(R.drawable.palakpaneer); // Replace with actual image resource

        ImageView foodImage6 = findViewById(R.id.foodImage6);
        foodImage6.setImageResource(R.drawable.naan); // Replace with actual image resource

        ImageView foodImage7 = findViewById(R.id.foodImage7);
        foodImage7.setImageResource(R.drawable.paneer); // Replace with actual image resource

        ImageView foodImage8 = findViewById(R.id.foodImage8);
        foodImage8.setImageResource(R.drawable.tandoori); // Replace with actual image resource

        ImageView foodImage9 = findViewById(R.id.foodImage9);
        foodImage9.setImageResource(R.drawable.vegbiriyani); // Replace with actual image resource

        ImageView foodImage10 = findViewById(R.id.foodImage10);
        foodImage10.setImageResource(R.drawable.dhoklajpeg); // Replace with actual image resource
    }
}
