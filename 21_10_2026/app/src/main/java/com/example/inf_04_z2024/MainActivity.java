package com.example.inf_04_z2024;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    EditText imie;
    ListView gatunek;
    TextView ileLat;
    SeekBar wiek;
    EditText cel;
    EditText godzina;
    Button ok;
    TextView pole;

    String[] gatunki = {"pies", "kot", "świnka morska"};
    String wybranyGatunek;
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
        imie = findViewById(R.id.imie);
        gatunek = findViewById(R.id.gatunek);
        ileLat = findViewById(R.id.ileLat);
        wiek = findViewById(R.id.wiek);
        cel = findViewById(R.id.cel);
        godzina = findViewById(R.id.godzina);
        pole = findViewById(R.id.pole);
        ok = findViewById(R.id.ok);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                gatunki
        );
        gatunek.setAdapter(adapter);

        gatunek.setOnItemClickListener((parent, view, position, id)->{
            wybranyGatunek = gatunki[position];

            switch(wybranyGatunek){
                case "pies":
                    wiek.setMax(18);
                    break;
                case "kot":
                    wiek.setMax(20);
                    break;
                case "świnka morska":
                    wiek.setMax(9);
                    break;
                default:
                    break;
            }
        });


        wiek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ileLat.setText("Ile ma lat? "+ seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ok.setOnClickListener(v ->{
            pole.setText("Imię i nazwisko: "+ imie.getText() + "\nGatunek: " + wybranyGatunek + "\n " + wiek.getProgress() + " lat \nCel wizyty: " + cel.getText() + "\nGodzina: " + godzina.getText());
        });
    }
}