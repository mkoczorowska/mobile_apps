package com.example.a09_02_2026;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class ReportedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reported);

        TextView name = findViewById(R.id.reported_name);
        TextView surname = findViewById(R.id.reported_surname);
        TextView className = findViewById(R.id.reported_class);
        Button back = findViewById(R.id.button_back);

        name.setText(getIntent().getStringExtra("name"));
        surname.setText(getIntent().getStringExtra("surname"));
        className.setText(getIntent().getStringExtra("class"));

        back.setOnClickListener(v -> finish());
    }
}