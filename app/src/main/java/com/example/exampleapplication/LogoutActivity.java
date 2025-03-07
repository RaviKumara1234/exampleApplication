package com.example.exampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        Button loginAgainButton = findViewById(R.id.loginAgainButton);
        loginAgainButton.setOnClickListener(v -> {
            Intent intent = new Intent(LogoutActivity.this, SecondActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
