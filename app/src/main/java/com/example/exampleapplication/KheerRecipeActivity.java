package com.example.exampleapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class KheerRecipeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kheer); // Set the layout for this specific recipe
    }
}
