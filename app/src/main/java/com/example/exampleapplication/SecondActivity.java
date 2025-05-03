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
import android.content.pm.PackageManager;
import android.telephony.SmsManager;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText usernameInput, passwordInput, phoneNumberInput, addressInput;
    private Button registerButton, loginButton;
    private ProgressDialog progressDialog;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        phoneNumberInput = findViewById(R.id.phoneNumberInput);
        addressInput = findViewById(R.id.addressInput);
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering...");
        progressDialog.setCancelable(false);

        databaseHelper = new DatabaseHelper(this);

        // Request SMS permission if not granted
        if (checkSelfPermission(android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.SEND_SMS}, 1);
        }

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                String phoneNumber = phoneNumberInput.getText().toString().trim();
                String address = addressInput.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!username.matches("[a-zA-Z]+")) {
                    Toast.makeText(SecondActivity.this, "Username should only contain letters", Toast.LENGTH_SHORT).show();
                } else if (!address.matches("[a-zA-Z ]+")) {
                    Toast.makeText(SecondActivity.this, "Address should only contain letters and spaces", Toast.LENGTH_SHORT).show();
                } else if (!password.matches("[a-zA-Z0-9]+")) {
                    Toast.makeText(SecondActivity.this, "Password should contain only alphanumeric characters", Toast.LENGTH_SHORT).show();
                } else if (phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]+")) {
                    Toast.makeText(SecondActivity.this, "Phone number should be 10 digits", Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.show();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();
                            boolean isInserted = databaseHelper.insertUser(username, password, phoneNumber, address);

                            if (isInserted) {
                                // Send SMS alert
                                sendSMS(phoneNumber, "Hi " + username + ", your registration is successful!");

                                showRegistrationSuccessDialog(username, phoneNumber, address);
                            } else {
                                Toast.makeText(SecondActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, 2000);
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showRegistrationSuccessDialog(String username, String phoneNumber, String address) {
        new AlertDialog.Builder(this)
                .setTitle("Registration Successful")
                .setMessage("Welcome, " + username + "!\nPhone: " + phoneNumber + "\nAddress: " + address + "\nYour registration is successful.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(SecondActivity.this, LoginActivity.class);
                        intent.putExtra("USERNAME", username);
                        intent.putExtra("PHONE_NUMBER", phoneNumber);
                        intent.putExtra("ADDRESS", address);
                        startActivity(intent);
                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void sendSMS(String phoneNumber, String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            // No Toast here — silent send
        } catch (Exception e) {
            e.printStackTrace(); // You may log this for debugging, but no Toast
        }
    }

}
