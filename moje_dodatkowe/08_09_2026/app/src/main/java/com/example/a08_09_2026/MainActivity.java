package com.example.a08_09_2026;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int w_uzytkownik = 0;
    private int w_komputer = 0;
    private TextView wynik_uzytkownik;
    private TextView wynik_komputer;
    private TextView wynik_rundy;
    private ImageView wybor_komputera_img;
    private final int[] idGrafik = {
            R.drawable.paper,
            R.drawable.rock,
            R.drawable.scissors
    };
    private final String[] opcje ={
            "paper",
            "rock",
            "scissors"
    };
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        wybor_komputera_img = findViewById(R.id.grafika);
        wynik_uzytkownik = findViewById(R.id.wynik_uzytkownik);
        wynik_komputer = findViewById(R.id.wynik_komputer);
        wynik_rundy = findViewById(R.id.wynik_rundy);

        Button paper_w = findViewById(R.id.paper);
        Button rock_w = findViewById(R.id.rock);
        Button scissors_w = findViewById(R.id.scissors);
        Button reset = findViewById(R.id.reset);

        paper_w.setOnClickListener(v -> zagraj_runde("paper"));
        rock_w.setOnClickListener(v -> zagraj_runde("rock"));
        scissors_w.setOnClickListener(v -> zagraj_runde("scissors"));
        reset.setOnClickListener(v -> reset());
    }

    private void zagraj_runde(String wybor_uzytkownika){
        int wybor_komputera = random.nextInt(3);
        wybor_komputera_img.setImageResource(idGrafik[wybor_komputera]);
        if(wybor_uzytkownika.equals(opcje[wybor_komputera])){
            wynik_rundy.setText("Remis");
        }
        else{
            switch (wybor_uzytkownika){
                case "paper":
                    if (opcje[wybor_komputera].equals("scissors")){
                        wynik_rundy.setText("Przegrana");
                        w_komputer ++;
                    }
                    else{
                        wynik_rundy.setText("Wygrana");
                        w_uzytkownik ++;
                    }
                    break;

                case "rock":
                    if (opcje[wybor_komputera].equals("paper")){
                        wynik_rundy.setText("Przegrana");
                        w_komputer ++;
                    }
                    else{
                        wynik_rundy.setText("Wygrana");
                        w_uzytkownik ++;
                    }
                    break;

                case "scissors":
                    if (opcje[wybor_komputera].equals("rock")){
                        wynik_rundy.setText("Przegrana");
                        w_komputer ++;
                    }
                    else{
                        wynik_rundy.setText("Wygrana");
                        w_uzytkownik ++;
                    }
                    break;
            }
            wynik_uzytkownik.setText("TY: " + w_uzytkownik);
            wynik_komputer.setText("KOMPUTER: " + w_komputer);
        }
    }

    private void reset(){
        w_uzytkownik = 0;
        w_komputer = 0;
        wynik_uzytkownik.setText("TY: " + w_uzytkownik);
        wynik_komputer.setText("KOMPUTER: " + w_komputer);
        wynik_rundy.setText("");
        wybor_komputera_img.setImageResource(R.drawable.question);
    }

}