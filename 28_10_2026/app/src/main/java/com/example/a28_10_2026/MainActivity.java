package com.example.a28_10_2026;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileOutputStream;
import java.io.IOException;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText klucz;
    EditText tekst;
    TextView szyfr;
    Button szyfruj;
    Button pobierz;
    String klucz_str;
    int klucz_val;
    String tekst_val;
    int znak_ascii;
    int znak_szyfr_ascii;
    char znak_szyfr;
    String zaszyfrowany_tekst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        klucz = findViewById(R.id.klucz);
        tekst = findViewById(R.id.tekst);
        szyfr = findViewById(R.id.szyfr);
        szyfruj = findViewById(R.id.szyfruj);
        pobierz = findViewById(R.id.pobierz);

        szyfruj.setOnClickListener(v->{
            if(tekst!=null){
                zaszyfrowany_tekst ="";
                if (klucz==null){
                    klucz_val = 0;
                }
                else{
                    klucz_str = klucz.getText().toString();
                    klucz_val = Integer.parseInt(klucz_str);
                }
                tekst_val = tekst.getText().toString();

                for (char znak : tekst_val.toCharArray()){
                    znak_ascii = (int) znak;
                    znak_szyfr_ascii = znak_ascii + klucz_val;
                    znak_szyfr = (char) znak_szyfr_ascii;
                    zaszyfrowany_tekst += znak_szyfr;
                }

                szyfr.setText(zaszyfrowany_tekst);
            }
        });

        pobierz.setOnClickListener(v->{
            try {
                FileOutputStream plik = openFileOutput("szyfr.txt", MODE_PRIVATE);
                plik.write(zaszyfrowany_tekst.getBytes());
                plik.close();
                Toast.makeText(this, "Zapisano plik!", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}