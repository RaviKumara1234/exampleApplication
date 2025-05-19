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

    private EditText usernameInput, passwordInput, phoneNumberInput, addressInput, emailInput;
    private Button registerButton, loginButton;
    private ProgressDialog progressDialog;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize UI elements
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        phoneNumberInput = findViewById(R.id.phoneNumberInput);
        addressInput = findViewById(R.id.addressInput);
        emailInput = findViewById(R.id.emailInput);
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
                String email = emailInput.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || address.isEmpty() || email.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!username.matches("[a-zA-Z]+")) {
                    Toast.makeText(SecondActivity.this, "Username should only contain letters", Toast.LENGTH_SHORT).show();
                } else if (!address.matches("[a-zA-Z ]+")) {
                    Toast.makeText(SecondActivity.this, "Address should only contain letters and spaces", Toast.LENGTH_SHORT).show();
                } else if (!password.matches("[a-zA-Z0-9]+")) {
                    Toast.makeText(SecondActivity.this, "Password should contain only alphanumeric characters", Toast.LENGTH_SHORT).show();
                } else if (phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]+")) {
                    Toast.makeText(SecondActivity.this, "Phone number should be 10 digits", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(SecondActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.show();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();
                            boolean isInserted = databaseHelper.insertUser(username, password, phoneNumber, address, email);

                            if (isInserted) {
                                sendSMS(phoneNumber, "Hi " + username + ", your registration is successful!");
                                sendEmail(email, username); // <-- Send email notification
                                showRegistrationSuccessDialog(username, phoneNumber, address, email);
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

    private void showRegistrationSuccessDialog(String username, String phoneNumber, String address, String email) {
        new AlertDialog.Builder(this)
                .setTitle("Registration Successful")
                .setMessage("Welcome, " + username + "!\nPhone: " + phoneNumber + "\nAddress: " + address + "\nEmail: " + email + "\nYour registration is successful.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(SecondActivity.this, LoginActivity.class);
                        intent.putExtra("USERNAME", username);
                        intent.putExtra("PHONE_NUMBER", phoneNumber);
                        intent.putExtra("ADDRESS", address);
                        intent.putExtra("EMAIL", email);
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
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(SecondActivity.this, "Failed to send SMS.", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendEmail(String email, String username) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Registration Confirmation");
        intent.putExtra(Intent.EXTRA_TEXT, "Hello " + username + ",\n\nThank you for registering. Your account has been successfully created!\n\n- Example App");

        try {
            startActivity(Intent.createChooser(intent, "Send email using..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "No email clients installed on your device.", Toast.LENGTH_SHORT).show();
        }
    }

    // Handle permission result
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "SMS Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "SMS Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
