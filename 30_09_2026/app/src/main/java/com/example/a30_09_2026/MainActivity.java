package com.example.a30_09_2026;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nowy_element;
    Button dodaj;
    ListView lista;

    ArrayList<String> elementy;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nowy_element = findViewById(R.id.nowy_element);
        dodaj = findViewById(R.id.dodaj);
        lista = findViewById(R.id.lista);

        elementy = new ArrayList<>();
        elementy.add("Notatka 1");
        elementy.add("Notatka 2");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, elementy);

        lista.setAdapter(adapter);

        dodaj.setOnClickListener(v->{
            elementy.add(nowy_element.getText().toString());
            nowy_element.setText("");
            adapter.notifyDataSetChanged();
        });
    }
}