package com.example.lovify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovify.databinding.ActivitySplashScreen03Binding;

public class SplashScreen03 extends AppCompatActivity {
    private ActivitySplashScreen03Binding binding;
    TextView txtMSg, txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreen03Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txtMSg=findViewById(R.id.txtMsg03);
        txtDesc=findViewById(R.id.txtdesc03);

        //Add onClick Listener on Skip txt
        binding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(SplashScreen03.this, "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        //Add onClick Listener on Back text
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(SplashScreen03.this, "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SplashScreen02.class);
                startActivity(intent);
                finish();
            }
        });

        //Add onClick Listener on Start Button
        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(SplashScreen03.this, "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });


    }
}