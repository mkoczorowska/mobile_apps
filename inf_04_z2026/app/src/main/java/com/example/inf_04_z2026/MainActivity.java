package com.example.inf_04_z2026;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView[] kosci = new ImageView[5];
    Boolean[] czyDostepna = {true, true, true, true, true};
    int[] wyniki = {0,0,0,0,0};
    int[] obrazy = {
            R.drawable.kosc0,
            R.drawable.kosc1,
            R.drawable.kosc2,
            R.drawable.kosc3,
            R.drawable.kosc4,
            R.drawable.kosc5,
            R.drawable.kosc6
    };
    Button btn;
    TextView wynik;

    Random random = new Random();
    int suma;

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

        kosci[0] = findViewById(R.id.kosc1);
        kosci[1] = findViewById(R.id.kosc2);
        kosci[2] = findViewById(R.id.kosc3);
        kosci[3] = findViewById(R.id.kosc4);
        kosci[4] = findViewById(R.id.kosc5);

        btn = findViewById(R.id.btn);
        wynik = findViewById(R.id.wynik);

        for(int i=0; i<5; i++){
            final int indeks = i;
            kosci[indeks].setOnClickListener(v->{
                if(czyDostepna[indeks]){
                    czyDostepna[indeks]=false;
                    kosci[indeks].setAlpha(0.5f);
                }
                else{
                    czyDostepna[indeks]=true;
                    kosci[indeks].setAlpha(1f);
                }
            });
        }

        btn.setOnClickListener(v->{
            suma=0;
            for(int i = 0; i<5; i++){
                if(czyDostepna[i]){
                    wyniki[i] = random.nextInt(6)+1;
                    kosci[i].setImageResource(obrazy[wyniki[i]]);
                }
                suma += wyniki[i];
            }
            wynik.setText(String.valueOf(suma));
        });
    }
}