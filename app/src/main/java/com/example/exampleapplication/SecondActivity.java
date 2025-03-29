package com.example.exampleapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText usernameInput, passwordInput, phoneNumberInput, addressInput;
    private Button registerButton;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize UI components
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        phoneNumberInput = findViewById(R.id.phoneNumberInput);
        addressInput = findViewById(R.id.addressInput);
        registerButton = findViewById(R.id.registerButton);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering...");
        progressDialog.setCancelable(false);

        // Handle Register Button Click
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                String phoneNumber = phoneNumberInput.getText().toString().trim();
                String address = addressInput.getText().toString().trim();

                // Validate inputs
                if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!username.matches("[a-zA-Z]+")) { // Check if username contains only letters
                    Toast.makeText(SecondActivity.this, "Username should only contain letters", Toast.LENGTH_SHORT).show();
                } else if (!address.matches("[a-zA-Z ]+")) { // Check if address contains only letters and spaces
                    Toast.makeText(SecondActivity.this, "Address should only contain letters and spaces", Toast.LENGTH_SHORT).show();
                } else if (!password.matches("[a-zA-Z0-9]+")) { // Check if password contains only alphanumeric characters
                    Toast.makeText(SecondActivity.this, "Password should contain only alphanumeric characters", Toast.LENGTH_SHORT).show();
                } else if (phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]+")) { // Check if phone number is exactly 10 digits
                    Toast.makeText(SecondActivity.this, "Phone number should be 10 digits", Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.show();

                    // Simulate registration delay
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();

                            // Show Registration Successful Dialog
                            showRegistrationSuccessDialog(username, phoneNumber, address);
                        }
                    }, 2000); // 2 seconds delay
                }
            }
        });
    }

    // Show Registration Success Dialog Box
    private void showRegistrationSuccessDialog(String username, String phoneNumber, String address) {
        new AlertDialog.Builder(this)
                .setTitle("Registration Successful")
                .setMessage("Welcome, " + username + "!\nPhone: " + phoneNumber + "\nAddress: " + address + "\nYour registration is successful.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Pass the user info to ThirdActivity
                        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                        intent.putExtra("USERNAME", username);
                        intent.putExtra("PHONE_NUMBER", phoneNumber);
                        intent.putExtra("ADDRESS", address);
                        startActivity(intent);
                        finish(); // Close current activity
                    }
                })
                .setCancelable(false)
                .show();
    }
}
