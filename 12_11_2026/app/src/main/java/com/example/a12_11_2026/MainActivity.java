package com.example.a12_11_2026;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    View prostokat;
    TextView r_number;
    TextView g_number;
    TextView b_number;
    SeekBar r;
    SeekBar g;
    SeekBar b;
    Button przycisk;
    TextView wynik;
    int r_wynik;
    int g_wynik;
    int b_wynik;

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
        prostokat = findViewById(R.id.prostokat);
        r = findViewById(R.id.r);
        g = findViewById(R.id.g);
        b = findViewById(R.id.b);
        r_number = findViewById(R.id.r_number);
        g_number = findViewById(R.id.g_number);
        b_number = findViewById(R.id.b_number);
        przycisk = findViewById(R.id.przycisk);
        wynik = findViewById(R.id.wynik);

        przycisk.setOnClickListener(v->{
            r_wynik = r.getProgress();
            g_wynik = g.getProgress();
            b_wynik = b.getProgress();

            wynik.setText(""+r_wynik+", "+g_wynik+", "+b_wynik);
            wynik.setBackgroundColor(Color.rgb(r_wynik, g_wynik, b_wynik));
            wynik.setTextColor(Color.rgb(255-r_wynik, 255-g_wynik ,255-b_wynik));
        });

        r.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean bool) {
                r_number.setText(""+r.getProgress());
                prostokat.setBackgroundColor(Color.rgb(r.getProgress(), g.getProgress(), b.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean bool) {
                g_number.setText(""+g.getProgress());
                prostokat.setBackgroundColor(Color.rgb(r.getProgress(), g.getProgress(), b.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean bool) {
                b_number.setText(""+b.getProgress());
                prostokat.setBackgroundColor(Color.rgb(r.getProgress(), g.getProgress(), b.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}