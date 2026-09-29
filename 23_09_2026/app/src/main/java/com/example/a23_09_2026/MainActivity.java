package com.example.a23_09_2026;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private TextView cytat;
    private TextView rozmiar;
    private SeekBar suwak;
    private Button przycisk;
    private int index;
    private int progress;
    private static final String[] cytaty =  {"Dzień Dobry", "Good morning", "Buenos Dias"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        index = 0;

        cytat = findViewById(R.id.cytat);
        rozmiar = findViewById(R.id.rozmiar);
        suwak = findViewById(R.id.suwak);
        przycisk = findViewById(R.id.przycisk);

        przycisk.setOnClickListener(v -> zmien());
        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar suwak, int progressValue, boolean fromuser){
                progress = progressValue;
                rozmiar.setText("Rozmiar: " + progress);
                cytat.setTextSize(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void zmien(){
        index++;
        if (index == 3) {
            index = 0;
        }

        cytat.setText(cytaty[index]);
    }
}