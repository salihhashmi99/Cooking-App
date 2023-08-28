package com.example.lovify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.lovify.databinding.ActivityAboutUsBinding;

public class AboutUS extends AppCompatActivity {
    ActivityAboutUsBinding binding;
    NestedScrollView nestedScrollView;
    TextView txtAboutUs, txtparaAboutus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAboutUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        nestedScrollView = findViewById(R.id.nestedscrollview01);
        txtAboutUs = findViewById(R.id.txtTitle);
        txtparaAboutus= findViewById(R.id.txtparaAboutus);

    }
}