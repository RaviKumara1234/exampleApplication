package com.example.exampleapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    private EditText usernameInput, passwordInput;
    private Button loginButton;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Setup Toolbar for Menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize UI components
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging in...");
        progressDialog.setCancelable(false);

        // Handle Login Button Click
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.show();

                    // Simulate login delay
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();

                            // Show Registration Successful Dialog
                            showRegistrationSuccessDialog(username);
                        }
                    }, 2000); // 2 seconds delay
                }
            }
        });
    }

    // Show Registration Success Dialog Box
    private void showRegistrationSuccessDialog(String username) {
        new AlertDialog.Builder(this)
                .setTitle("Registration Successful")
                .setMessage("Welcome, " + username + "! Your registration is successful.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Move to ThirdActivity after clicking OK
                        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                        intent.putExtra("USERNAME", username);
                        startActivity(intent);
                        finish(); // Close current activity
                    }
                })
                .setCancelable(false)
                .show();
    }

    // Load the menu properly
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    // Handle menu item selection
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId(); // Get selected item ID

        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (id == R.id.action_profile) {
            startActivity(new Intent(this, ProfileActivity.class));
            return true;
        } else if (id == R.id.action_logout) {
            Toast.makeText(this, "Logout Successful", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
