package com.example.a23_03_2026;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}