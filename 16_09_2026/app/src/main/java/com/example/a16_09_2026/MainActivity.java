package com.example.a16_09_2026;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView nr_prania;
    private TextView status;
    private Button btn_pralka;
    private Button btn_odkurzacz;
    private EditText et__pralka;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nr_prania = findViewById(R.id.nr_prania);
        status = findViewById(R.id.status_odkurzacz);
        btn_pralka = findViewById(R.id.button_pralka);
        btn_odkurzacz = findViewById(R.id.button_odkurzacz);
        et__pralka = findViewById(R.id.edit_text_pralka);
        random = new Random();

        btn_odkurzacz.setText("Włącz");
        status.setText("Odkurzacz wyłączony");

        btn_pralka.setOnClickListener(v -> Pralka());
        btn_odkurzacz.setOnClickListener(v-> Odkurzacz());
    }

    public void Pralka(){
        String dane = et__pralka.getText().toString();
        int liczba = Integer.parseInt(dane);

        if(1<=liczba && liczba<=12){
            nr_prania.setText("Numer prania: " + liczba);
        }
    }

    public void Odkurzacz(){
        if(btn_odkurzacz.getText()=="Włącz"){
            btn_odkurzacz.setText("Wyłącz");
            status.setText("Odkurzacz włączony");
        }
        else{
            btn_odkurzacz.setText("Włącz");
            status.setText("Odkurzacz wyłączony");
        }
    }
}