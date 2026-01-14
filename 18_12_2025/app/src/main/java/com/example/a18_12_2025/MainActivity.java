package com.example.a18_12_2025;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editPassword;
    private EditText editPasswordRepeat;
    private TextView textMessage;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editPasswordRepeat = findViewById(R.id.editPasswordRepeat);
        textMessage = findViewById(R.id.textMessage);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        textMessage.setText("Autor ...........");

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        String passwordRepeat = editPasswordRepeat.getText().toString();

        if (!email.contains("@")) {
            textMessage.setText("Nieprawidłowy adres e-mail");
        } else if (!password.equals(passwordRepeat)) {
            textMessage.setText("Hasła się różnią");
        } else {
            textMessage.setText("Witaj " + email);
        }
    }
}
