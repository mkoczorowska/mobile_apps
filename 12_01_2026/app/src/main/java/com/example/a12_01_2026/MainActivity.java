package com.example.a12_01_2026;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword, etRepeatPassword;
    Button btnSubmit;
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etRepeatPassword = findViewById(R.id.etRepeatPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvMessage = findViewById(R.id.tvMessage);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String repeatPassword = etRepeatPassword.getText().toString();

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    showError("Nieprawidłowy adres e-mail");
                } else if (!password.equals(repeatPassword)) {
                    showError("Hasła się różnią");
                } else if (!isPasswordValid(password)) {
                    showError("Hasło nie spełnia wymagań");
                } else {
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                }
            }
        });
    }

    private void showError(String message) {
        tvMessage.setTextColor(Color.RED);
        tvMessage.setText(message);
    }

    private boolean isPasswordValid(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
    }
}
