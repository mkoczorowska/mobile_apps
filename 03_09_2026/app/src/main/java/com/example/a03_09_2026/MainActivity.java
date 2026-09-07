package com.example.a03_09_2026;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView[] obrazyKosci;
    private TextView suma;
    private TextView wynik;
    private int wynikCalejGry = 0;
    private final Random random = new Random();
    private final int[] idGrafik = {
            R.drawable.k1,
            R.drawable.k2,
            R.drawable.k3,
            R.drawable.k4,
            R.drawable.k5,
            R.drawable.k6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        obrazyKosci = new ImageView[]{
                findViewById(R.id.kosc1),
                findViewById(R.id.kosc2),
                findViewById(R.id.kosc3),
                findViewById(R.id.kosc4),
                findViewById(R.id.kosc5)
        };
        suma = findViewById(R.id.suma);
        wynik = findViewById(R.id.wynik);

        Button rzut = findViewById(R.id.rzut);
        Button reset = findViewById(R.id.reset);

        rzut.setOnClickListener(v -> rzutKoscmi());
        reset.setOnClickListener(v -> resetGry());


    }

    private void rzutKoscmi(){
        int sumaRzutu = 0;

        for(int i=0; i<5; i++){
            int wartosc = random.nextInt(6)+1;
            sumaRzutu += wartosc;

            obrazyKosci[i].setImageResource(idGrafik[wartosc-1]);
        }
        wynikCalejGry += sumaRzutu;

        suma.setText("Wynik tego losowania: "+ sumaRzutu);
        wynik.setText("Wynik gry: "+ wynikCalejGry);
    }
    private void resetGry(){
        for(int i=0; i<5; i++){
            obrazyKosci[i].setImageResource(R.drawable.question);
        }
        suma.setText("Wynik tego losowania: 0");
        wynikCalejGry = 0;
        wynik.setText("Wynik gry: "+ wynikCalejGry);

    }
}