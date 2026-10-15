package com.example.inf_04_l2022;

import android.os.Bundle;

import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView polubienia;
    Button polub;
    Button usun;
    int licznik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        polubienia = findViewById(R.id.liczba_polubien);
        polub = findViewById(R.id.polub);
        usun = findViewById(R.id.usun);

        licznik = 0;

        polub.setOnClickListener(v -> {
            licznik ++;
            polubienia.setText(licznik + " polubień");
        });

        usun.setOnClickListener(v -> {
            if(licznik>0){
                licznik --;
                polubienia.setText(licznik + " polubień");
            }
        });
    }
}