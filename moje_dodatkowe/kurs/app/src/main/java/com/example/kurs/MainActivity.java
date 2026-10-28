package com.example.kurs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewTreeLifecycleOwner;

public class MainActivity extends AppCompatActivity {

    EditText dane;
    Spinner kurs;
    RadioGroup poziom;
    CheckBox certyfikat;
    CheckBox druk;
    Button ok;

    String[] kursy = {"Java", "Python", "C#", "HTML"};
    String certyfikat_val;
    String druk_val;
    String poziom_val;
    String dane_val;
    String kurs_val;
    int cena;

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

        dane = findViewById(R.id.dane);
        kurs = findViewById(R.id.kurs);
        poziom = findViewById(R.id.poziom);
        certyfikat = findViewById(R.id.certyfikat);
        druk = findViewById(R.id.druk);
        ok = findViewById(R.id.ok);

        ArrayAdapter<String> adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                kursy
        );

        kurs.setAdapter(adapter);

        ok.setOnClickListener(v->{
            poziom_val = "nie wybrano";
            certyfikat_val ="nie";
            druk_val ="nie";
            cena = 0;
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            dane_val = dane.getText().toString();
            kurs_val = kurs.getSelectedItem().toString();

            switch(kurs_val){
                case "Java":
                    cena+=200;
                    break;
                case "Python":
                    cena+=180;
                    break;
                case "C#":
                    cena+=220;
                    break;
                case "HTML":
                    cena+=160;
                    break;
            }

            int poziom_id = poziom.getCheckedRadioButtonId();

            if (poziom_id == R.id.poczatkujacy) {
                poziom_val = "początkujący";
            } else if (poziom_id == R.id.sredniozaawansowany) {
                poziom_val = "średniozaawansowany";
            } else if (poziom_id == R.id.zaawansowany) {
                poziom_val = "zaawansowany";
            }

            if(certyfikat.isChecked()){
                certyfikat_val = "tak";
                cena+=40;
            }
            if(druk.isChecked()){
                druk_val = "tak";
                cena+=25;
            }

            intent.putExtra("dane", dane_val);
            intent.putExtra("kurs", kurs_val);
            intent.putExtra("poziom", poziom_val);
            intent.putExtra("certyfikat", certyfikat_val);
            intent.putExtra("druk", druk_val);
            intent.putExtra("cena", cena);

            startActivity(intent);
        });
    }
}