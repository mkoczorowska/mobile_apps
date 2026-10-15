package com.example.a07_10_2026;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.AutoCompleteTextView;
import android.widget.SeekBar;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView rodzaj;
    Spinner rozmiar;
    TextView liczba;
    SeekBar liczba_porcji;
    Switch grubosc;
    Button dodaj;
    ListView zamowienia;
    Button zamow;

    String[] pizze_tab = {"Margherita", "Funghi", "Capriciosa", "Parma", "Jalapentttoooo"};
    String[] rozmiar_tab = {"mała", "średnia", "duża"};
    String czy_na_grubym = "";
    ArrayList<String> zamowienia_tab = new ArrayList<String>();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rodzaj = findViewById(R.id.rodzaj);
        rozmiar = findViewById(R.id.rozmiar);
        liczba = findViewById(R.id.liczba);
        liczba_porcji = findViewById(R.id.liczba_pocji);
        grubosc = findViewById(R.id.czy_grube);
        dodaj = findViewById(R.id.dodaj);
        zamowienia = findViewById(R.id.zamowienia);
        zamow = findViewById(R.id.zamow);


        ArrayAdapter<String> adapter_rodzaj = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                pizze_tab
        );
        rodzaj.setAdapter(adapter_rodzaj);

        ArrayAdapter<String> adapter_rozmiar = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                rozmiar_tab
        );
        rozmiar.setAdapter(adapter_rozmiar);

        ArrayAdapter<String> adapter_zamowienia = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                zamowienia_tab
        );
        zamowienia.setAdapter(adapter_zamowienia);

        liczba_porcji.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        liczba.setText("Liczba: " + String.valueOf(progress));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );


        dodaj.setOnClickListener(v ->{
            if(grubosc.isChecked()){
                czy_na_grubym = "na grubym cieście";
            }
            else{
                czy_na_grubym ="";
            }

            String zamowienie =
                    liczba_porcji.getProgress() + "x " +
                            rozmiar.getSelectedItem().toString() + " " +
                            rodzaj.getText().toString() + " " +
                            czy_na_grubym;

            zamowienia_tab.add(zamowienie);

            adapter_zamowienia.notifyDataSetChanged();
        });

        zamow.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    SecondActivity.class
            );
            intent.putStringArrayListExtra("tab", zamowienia_tab);
            startActivity(intent);
        });

    }
}