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

        //Add on Click Listener on the Burger Button
        binding.btnBurgerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Biryani Button
        binding.btnBiryaniCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Milkshake Button
        binding.btnMilkshakeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Pasta Button
        binding.btnPastaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Samosa Button
        binding.btnSamosaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Cupcake Button
        binding.btnBurgerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Luddo Button
        binding.btnLadduCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the Pizza Button
        binding.btnPizzaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
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
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                        //Yahan par wo code aay ga jo home k click par karna hai!
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
//                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                    };
                    case R.id.nav_contactus:{
                        Intent intent = new Intent(getApplicationContext(), ContactUs.class);
                        startActivity(intent);
                        finish();
                    }
                    case R.id.nav_login:{
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
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
                        Intent shareIntent = new Intent();
                        shareIntent.setAction(Intent.ACTION_SEND);
                        shareIntent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
                        shareIntent.setType("text/plain");
                        shareIntent = Intent.createChooser(shareIntent, "Share Via");
                        startActivity(shareIntent);
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
}