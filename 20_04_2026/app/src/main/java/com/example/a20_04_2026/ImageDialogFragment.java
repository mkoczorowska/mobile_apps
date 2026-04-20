package com.example.a20_04_2026;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class ImageDialogFragment extends DialogFragment {

    private static final String ARG_IMAGE = "image";

    public static ImageDialogFragment newInstance(int imageResId) {
        ImageDialogFragment fragment = new ImageDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE, imageResId);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_image, null);
        ImageView imageView = view.findViewById(R.id.dialogImage);

        int imageResId = getArguments().getInt(ARG_IMAGE);
        imageView.setImageResource(imageResId);

        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(view);
        return dialog;
    }
}