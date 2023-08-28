package com.example.lovify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.lovify.databinding.ActivityAnimationScreenBinding;

public class AnimationScreen extends AppCompatActivity {
    private ActivityAnimationScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAnimationScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //initializing and apply animation on app name
        binding.txtappname.animate().translationY(-1400).setDuration(2700).setStartDelay(0);

        //intializing and applying animation on Lottie file
        binding.lottieLove.setAnimation(R.raw.animation_lkr1cvoo);
        binding.lottieLove.animate().translationX(2000).setDuration(2000).setStartDelay(2900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), NoInternetScreen.class);
                startActivity(intent);
            }
        },5000);
    }
}
