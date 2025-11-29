package com.example.a27_11_2025;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private TextView textView;
    private EditText editText2;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        textView = findViewById(R.id.textView);
        editText2 = findViewById(R.id.editText2);
        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toastText = editText2.getText().toString();
                Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setTextInField(View view) {
        String text = editText1.getText().toString();
        textView.setText(text);
    }
}
