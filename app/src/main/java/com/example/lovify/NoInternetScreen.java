package com.example.lovify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lovify.databinding.ActivityNointernetScreenBinding;

import org.w3c.dom.Text;

public class NoInternetScreen extends AppCompatActivity {
    TextView txtOpps, txtNoInternet, txtDesc;
    ImageView imageView;
    private ActivityNointernetScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNointernetScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txtOpps=findViewById(R.id.txtOOPs);
        imageView=findViewById(R.id.imgViewNOinternet);
        txtNoInternet=findViewById(R.id.txtViewNointernet);
        txtDesc=findViewById(R.id.txtdesc);

        //add on OnClickListerner on the button
        binding.btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SplashScreen01.class);
                startActivity(intent);
                finish();
            }
        });
    }
}