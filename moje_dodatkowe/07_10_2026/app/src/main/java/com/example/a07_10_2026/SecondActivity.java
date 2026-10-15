package com.example.a07_10_2026;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity
{
    Button zamow;
    Button wroc;
    ListView zamowienia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        zamowienia = findViewById(R.id.zamowienia);
        zamow = findViewById(R.id.zamow);
        wroc = findViewById(R.id.wroc);

        zamow.setOnClickListener(v -> {
            finish();
            Toast.makeText(
                    SecondActivity.this,
                    "Zamówienie wysłane",
                    Toast.LENGTH_SHORT
            ).show();
        });

        wroc.setOnClickListener(v -> {
            finish();
        });

        ArrayList<String> zamowienia_tab = getIntent().getStringArrayListExtra("tab");
        ArrayAdapter<String> adapter_zamowienia = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                zamowienia_tab
        );
        zamowienia.setAdapter(adapter_zamowienia);
    }
}
