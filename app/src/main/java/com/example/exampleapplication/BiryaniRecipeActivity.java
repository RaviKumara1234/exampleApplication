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

public class BiryaniRecipeActivity extends AppCompatActivity {

    private Button addFavoriteButton;
    private DatabaseHelper dbHelper;
    private String recipeName = "Biryani";

    private static final String CHANNEL_ID = "favorites_channel"; // Common channel ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biryani);

        addFavoriteButton = findViewById(R.id.addFavoriteButton);
        dbHelper = new DatabaseHelper(this);

        if (dbHelper.isRecipeFavorite(recipeName)) {
            addFavoriteButton.setText("Remove from Favorites");
        }

        // Create the notification channel
        createNotificationChannel();

        addFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dbHelper.isRecipeFavorite(recipeName)) {
                    dbHelper.removeFavoriteRecipe(recipeName);
                    addFavoriteButton.setText("Add to Favorites");
                    Toast.makeText(BiryaniRecipeActivity.this, recipeName + " removed from favorites!", Toast.LENGTH_SHORT).show();
                    sendNotification(recipeName + " removed from favorites!");
                } else {
                    dbHelper.addFavoriteRecipe(recipeName);
                    addFavoriteButton.setText("Remove from Favorites");
                    Toast.makeText(BiryaniRecipeActivity.this, recipeName + " added to favorites!", Toast.LENGTH_SHORT).show();
                    sendNotification(recipeName + " added to favorites!");
                }
            }
        });
    }

    // Create notification channel (for Android Oreo and above)
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

    // Send notification
    private void sendNotification(String message) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("Recipe Favorites")
                    .setContentText(message)
                    .setSmallIcon(R.mipmap.ic_launcher) // Replace with custom icon if available
                    .setAutoCancel(true)
                    .build();
        }

        if (notification != null) {
            notificationManager.notify(5, notification); // Unique ID for Biryani
        }
    }
}
