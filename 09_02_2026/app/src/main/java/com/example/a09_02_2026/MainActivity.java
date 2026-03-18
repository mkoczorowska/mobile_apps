package com.example.a09_02_2026;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, surname, className;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.input_name);
        surname = findViewById(R.id.input_surname);
        className = findViewById(R.id.input_class);
        button = findViewById(R.id.button_save);

        button.setOnClickListener(v -> {

            String n = name.getText().toString();
            String s = surname.getText().toString();
            String c = className.getText().toString();

            if (n.isEmpty() || s.isEmpty() || c.isEmpty()) {
                Toast.makeText(this, "Wypełnij wszystkie pola!", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, ReportedActivity.class);
            intent.putExtra("name", n);
            intent.putExtra("surname", s);
            intent.putExtra("class", c);

            ProgressDialog dialog = new ProgressDialog(this);
            dialog.setTitle("Dodaję uwagę...");
            dialog.setMessage("Proszę czekać.");
            dialog.show();

            name.setText("");
            surname.setText("");
            className.setText("");

            new Handler().postDelayed(() -> {
                dialog.dismiss();
                startActivity(intent);
            }, 2000);
        });
    }
}