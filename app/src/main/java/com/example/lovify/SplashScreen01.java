package com.example.lovify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovify.databinding.ActivitySplashScreen01Binding;

public class SplashScreen01 extends AppCompatActivity {
    private ActivitySplashScreen01Binding binding;
    ImageView imgfood, imgWhite;
    TextView txtMsg, txtdesc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashScreen01Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imgfood=findViewById(R.id.shapeableImageView);
        imgWhite=findViewById(R.id.imgwhite);
        txtMsg=findViewById(R.id.txtMsg01);
        txtdesc=findViewById(R.id.txtdesc);


        //set on Click listener on the Next btn
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SplashScreen02.class);
                startActivity(intent);
                finish();
            }
        });

        //set onClick Listener on the skip button
        binding.Skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}