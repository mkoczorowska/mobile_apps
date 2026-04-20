package com.example.a20_04_2026;

import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

public class ImageAdapter {

    public interface OnImageClickListener {
        void onImageClick(int imageResId);
    }

    private List<Integer> images;
    private OnImageClickListener listener;

    public ImageAdapter(List<Integer> images, OnImageClickListener listener) {
        this.images = images;
        this.listener = listener;
    }

    public void populate(LinearLayout container) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());

        for (int resId : images) {
            ImageView imageView = (ImageView) inflater.inflate(R.layout.item_image, container, false);
            imageView.setImageResource(resId);
            imageView.setOnClickListener(v -> listener.onImageClick(resId));
            container.addView(imageView);
        }
    }
}
