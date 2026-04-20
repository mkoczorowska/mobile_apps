package com.example.a20_04_2026;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ImageAdapter.OnImageClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> images = Arrays.asList(
                R.drawable.img1, R.drawable.img2, R.drawable.img3,
                R.drawable.img4, R.drawable.img5, R.drawable.img6,
                R.drawable.img7, R.drawable.img8, R.drawable.img9,
                R.drawable.img10, R.drawable.img11, R.drawable.img12
                //, R.drawable.img13, R.drawable.img14, R.drawable.img15
        );

        LinearLayout container = findViewById(R.id.imageContainer);
        ImageAdapter adapter = new ImageAdapter(images, this);
        adapter.populate(container);
    }
    @Override
    public void onImageClick(int imageResId) {
        ImageDialogFragment dialog = ImageDialogFragment.newInstance(imageResId);
        dialog.show(getSupportFragmentManager(), "image_dialog");
    }
}