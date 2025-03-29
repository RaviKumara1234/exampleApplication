package com.example.exampleapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView usernameText, phoneText, addressText;
    private ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize UI components
        usernameText = findViewById(R.id.usernameText);
        phoneText = findViewById(R.id.phoneText);
        addressText = findViewById(R.id.addressText);
        profileImage = findViewById(R.id.profileImage);

        // Retrieve the data passed from SecondActivity
        String username = getIntent().getStringExtra("USERNAME");
        String phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");
        String address = getIntent().getStringExtra("ADDRESS");
        String profileImageUrl = getIntent().getStringExtra("PROFILE_IMAGE_URL"); // Optional: If you want to pass a URL

        // Set the retrieved values into the TextViews
        usernameText.setText("Username: " + username);
        phoneText.setText("Phone: " + phoneNumber);
        addressText.setText("Address: " + address);

        // Optional: Load a profile image from URL (if passed) using Glide or Picasso
        if (profileImageUrl != null && !profileImageUrl.isEmpty()) {
            // For example, using Glide:
            // Glide.with(this).load(profileImageUrl).into(profileImage);
        } else {
            // Set a default image if no URL is provided
            profileImage.setImageResource(R.drawable.default_user_logo1);  // Placeholder image
        }
    }
}
