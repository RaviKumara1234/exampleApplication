package com.example.exampleapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Get username from intent
        String username = getIntent().getStringExtra("USERNAME");

        // Display username
        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome, " + username + " to our App !");
    }
}
