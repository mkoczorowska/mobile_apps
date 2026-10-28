package com.example.inf_04_z2022;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText email;
        EditText haslo;
        EditText haslo2;
        Button zatwierdz;
        TextView wynik;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        email = findViewById(R.id.email);
        haslo = findViewById(R.id.haslo);
        haslo2 = findViewById(R.id.haslo2);
        zatwierdz = findViewById(R.id.zatwierdz);
        wynik = findViewById(R.id.wynik);

        zatwierdz.setOnClickListener(v->{
            String email_val = email.getText().toString();
            String haslo_val = haslo.getText().toString();
            String haslo2_val = haslo2.getText().toString();

            if(!email_val.contains("@")){
                wynik.setText("Nieprawidłowy adres e-mail");
            }
            else if(!haslo_val.equals(haslo2_val)){
                wynik.setText("Hasła się różnią");
            }
            else{
                wynik.setText("Witaj "+ email_val);
            }
        });
    }
}