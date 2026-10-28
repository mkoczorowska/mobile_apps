package com.example.kurs;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    TextView wynik;
    String dane;
    String kurs;
    String poziom;
    String certyfikat;
    String druk;
    TextView cena_txt;
    int cena;
    Button zapisz;
    Button wroc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        wynik = findViewById(R.id.wynik);
        cena_txt = findViewById(R.id.cena);
        zapisz = findViewById(R.id.zapisz);
        wroc = findViewById(R.id.wroc);

        dane = getIntent().getStringExtra("dane");
        kurs = getIntent().getStringExtra("kurs");
        poziom = getIntent().getStringExtra("poziom");
        certyfikat = getIntent().getStringExtra("certyfikat");
        druk = getIntent().getStringExtra("druk");
        cena = getIntent().getIntExtra("cena", 0);

        wynik.setText(
                "\nImię i nazwisko: " + dane
                        + "\nKurs: " + kurs
                        + "\nPoziom: " + poziom
                        + "\nCertyfikat: " + certyfikat
                        + "\nMateriały do druku: " + druk
        );

        cena_txt.setText("Cena: " + cena + " zł");

        wroc.setOnClickListener(v -> finish());

        zapisz.setOnClickListener(v -> {
            Toast.makeText(
                    SecondActivity.this,
                    "Zapisano na kurs!",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}

