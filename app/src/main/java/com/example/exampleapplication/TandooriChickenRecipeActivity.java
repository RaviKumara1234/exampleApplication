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

public class TandooriChickenRecipeActivity extends AppCompatActivity {

    private Button addFavoriteButton;
    private DatabaseHelper dbHelper;
    private String recipeName = "Tandoori Chicken";

    private static final String CHANNEL_ID = "favorites_channel"; // Shared channel ID for notifications

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tandoori_chicken);

        addFavoriteButton = findViewById(R.id.addFavoriteButton);
        dbHelper = new DatabaseHelper(this);

        // Check if the recipe is already in favorites
        if (dbHelper.isRecipeFavorite(recipeName)) {
            addFavoriteButton.setText("Remove from Favorites");
        }

        // Create notification channel once
        createNotificationChannel();

        // Handle the button click to add/remove from favorites
        addFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dbHelper.isRecipeFavorite(recipeName)) {
                    // Remove from favorites
                    dbHelper.removeFavoriteRecipe(recipeName);
                    addFavoriteButton.setText("Add to Favorites");
                    Toast.makeText(TandooriChickenRecipeActivity.this, recipeName + " removed from favorites!", Toast.LENGTH_SHORT).show();
                    sendNotification(recipeName + " removed from favorites!");
                } else {
                    // Add to favorites
                    dbHelper.addFavoriteRecipe(recipeName);
                    addFavoriteButton.setText("Remove from Favorites");
                    Toast.makeText(TandooriChickenRecipeActivity.this, recipeName + " added to favorites!", Toast.LENGTH_SHORT).show();
                    sendNotification(recipeName + " added to favorites!");
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
            notificationManager.notify(35, notification); // Unique ID for Tandoori Chicken
        }
    }
}
