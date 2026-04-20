package com.example.a23_03_2026;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_NOTIFICATIONS = 100;

    private static final String CHANNEL_HIGH = "high_channel";
    private static final String CHANNEL_LOW = "low_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 🔥 PROŚBA O UPRAWNIENIE (Android 13+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(
                        new String[]{Manifest.permission.POST_NOTIFICATIONS},
                        REQUEST_CODE_NOTIFICATIONS
                );
            }
        }

        createNotificationChannels();

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(v -> showHighPriorityNotification());
        btn2.setOnClickListener(v -> showLowPriorityNotification());
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel high = new NotificationChannel(
                    CHANNEL_HIGH,
                    "High Priority",
                    NotificationManager.IMPORTANCE_HIGH
            );

            NotificationChannel low = new NotificationChannel(
                    CHANNEL_LOW,
                    "Low Priority",
                    NotificationManager.IMPORTANCE_LOW
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(high);
            manager.createNotificationChannel(low);
        }
    }

    private void showHighPriorityNotification() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                        != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this, "Brak zgody na powiadomienia", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, Activity2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_HIGH)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Powiadomienie HIGH")
                .setContentText("Kliknij aby przejść do Activity 2")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat.from(this).notify(1, builder.build());
    }

    private void showLowPriorityNotification() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                        != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this, "Brak zgody na powiadomienia", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, Activity3.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 1, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_LOW)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Powiadomienie LOW")
                .setContentText("Kliknij aby przejść do Activity 3")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat.from(this).notify(2, builder.build());
    }
}