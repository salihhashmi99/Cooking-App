package com.example.lovify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovify.databinding.ActivitySplashScreen02Binding;

public class SplashScreen02 extends AppCompatActivity {
    private ActivitySplashScreen02Binding binding;
    TextView txtMsg, txtdesc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashScreen02Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txtMsg=findViewById(R.id.txtmsg02);
        txtdesc=findViewById(R.id.txtdesc02);

        //add onclick listener on the Skip Button
        binding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SplashScreen02.this, "Directed towards login Screen", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });

        //add onClickListener on the Back Button
        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(SplashScreen02.this, "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SplashScreen01.class);
                startActivity(intent);
                finish();
            }
        });

        //add OnclickListener on the Next Button
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SplashScreen02.this, "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SplashScreen03.class);
                startActivity(intent);
            }
        });
    }
}