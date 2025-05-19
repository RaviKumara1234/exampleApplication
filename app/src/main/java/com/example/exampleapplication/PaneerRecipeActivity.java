package com.example.exampleapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PaneerRecipeActivity extends AppCompatActivity {

    private Button addToFavoriteBtn;

    private static final String CHANNEL_ID = "favorites_channel"; // Shared channel ID for notifications

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paneer); // Set the layout for this specific recipe

        addToFavoriteBtn = findViewById(R.id.addToFavoriteBtn);

        // Create notification channel once
        createNotificationChannel();

        // Set up button click listener
        addToFavoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize DatabaseHelper
                DatabaseHelper dbHelper = new DatabaseHelper(PaneerRecipeActivity.this);

                // Check if recipe is already in favorites
                if (dbHelper.isRecipeFavorite("Paneer Butter Masala")) {
                    Toast.makeText(PaneerRecipeActivity.this, "Already in favorites", Toast.LENGTH_SHORT).show();
                } else {
                    // Add to favorites
                    dbHelper.addFavoriteRecipe("Paneer Butter Masala");
                    Toast.makeText(PaneerRecipeActivity.this, "Added to favorites!", Toast.LENGTH_SHORT).show();
                    sendNotification("Paneer Butter Masala added to favorites!");
                }
            }
        });
    }

    // Method to create the notification channel (required for Android O and above)
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Favorites Notifications";
            String description = "Notifications for adding/removing favorites";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    // Method to send the notification
    private void sendNotification(String message) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("Recipe Favorites")
                    .setContentText(message)
                    .setSmallIcon(R.mipmap.ic_launcher) // Replace with your app icon
                    .setAutoCancel(true)
                    .build();
        }

        if (notification != null) {
            notificationManager.notify(29, notification);
        }
    }
}
