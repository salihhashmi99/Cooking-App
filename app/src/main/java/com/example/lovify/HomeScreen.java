package com.example.lovify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovify.databinding.ActivityHomeScreenBinding;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class HomeScreen extends AppCompatActivity {

    boolean hasProvidedFeedback= false; //initially user has not provided the feedback
    TextView textView;

    FirebaseAuth mAuth;
    private ActivityHomeScreenBinding binding;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth=FirebaseAuth.getInstance();

        binding.toolBar.imgViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        //Add on Click Listener on the Pizza Button
        binding.btnBurgerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PizzaScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Biryani Button
        binding.btnBiryaniCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BiryaniScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Milkshake Button
        binding.btnMilkshakeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MilkshakeScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Pasta Button
        binding.btnPastaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PastaScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Samosa Button
        binding.btnSamosaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SamosaScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Burger Button
        binding.btnBurgerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, BurgerScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Luddo Button
        binding.btnLadduCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LadduScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Cupcake Button
        binding.btnPizzaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CupcakeScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void showPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.main_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:{
                        Toast.makeText(HomeScreen.this, "You are already on Home Screen", Toast.LENGTH_SHORT).show();
                    };
                    case R.id.aboutus:{
                        Intent intent = new Intent(getApplicationContext(), AboutUS.class);
                        startActivity(intent);
                        finish();
                    };
                    case R.id.feedback:{
                        if (!hasProvidedFeedback){
                            hasProvidedFeedback=true;
                            Intent intent = new Intent();
                            startActivity(intent);
                            break;
                        }
                        else
                        {
                            showAlreadyRatedMessage();
                        }

                    };
                    case R.id.nav_contactus:{
                        Intent intent = new Intent(getApplicationContext(), ContactUs.class);
                        startActivity(intent);
                        finish();
                    }
                    case R.id.nav_login:{
                        Toast.makeText(HomeScreen.this, "You are already logged in", Toast.LENGTH_SHORT).show();
                    };
                    case R.id.nav_logout:{
                        mAuth.signOut();
                        performLogout();
                    };
                    case R.id.nav_profile:{

                    };
                    case R.id.nav_rateus:{
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                    };
                    case R.id.nav_share:{
                        shareApp();
                    }
                }
                return true;
            }

            private void performLogout(){
                Intent intent = new Intent(getApplicationContext(),Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }

            private void showAlreadyRatedMessage() {
            }
        });
        popupMenu.show();
    }

    private void shareApp() {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
            String shareMessage = "Let me recommend you this application";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}