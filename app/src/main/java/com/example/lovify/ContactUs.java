package com.example.lovify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lovify.databinding.ActivityContactUsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactUs extends AppCompatActivity {
    private ActivityContactUsBinding binding;
    TextView txtcontact, txtMessage, txtName, txtemail, txtMsg;
    EditText edtName, edtEmail, edtMessage;

    private DatabaseReference mDatabase;
//    private ContactFormModel contactformmodel;
    private FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityContactUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseDatabase=FirebaseDatabase.getInstance();
        mDatabase=firebaseDatabase.getReference();

        txtcontact=findViewById(R.id.txtcontactUs);
        txtMessage=findViewById(R.id.txtmessage);
        txtName=findViewById(R.id.txtname);
        txtemail=findViewById(R.id.txtEmail);
        txtMsg=findViewById(R.id.txtmsg);

        edtName=findViewById(R.id.edtname);
        edtEmail=findViewById(R.id.edtemail);
        edtMessage=findViewById(R.id.edtmsg);

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String msg= edtMessage.getText().toString().trim();

                if (TextUtils.isEmpty(name)){
                    edtName.setError("Please Enter your name");
                    edtName.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(email)){
                    edtEmail.setError("Please Enter the Email Address");
                    edtEmail.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(msg)){
                    edtMessage.setError("Please convey the message");
                    edtMessage.requestFocus();
                    return;
                }
                else
                {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String u_id = user.getUid();


                }
                //if characters are less than 100
            }
        });

        //Add on Click Listener on the Submit Button
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Add onClick Listener on facebook Image
        binding.imgfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FacebookURI="https://www.facebook.com/salih.tanveer";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(FacebookURI));
                startActivity(intent);
            }
        });

        //Add onClick Listener on instagram Image
        binding.imginsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String InstagramURL="https://www.instagram.com/mohtaram.salihhashmi/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(InstagramURL));
                startActivity(intent);
            }
        });

        //Add onClick Listener on twitter Image
        binding.imgtwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String twitterURL = "https://twitter.com/be_like_buster";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(twitterURL));
                startActivity(intent);
            }
        });

        //Add onClick Listener on youtube Image
        binding.imgyoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String youtubeURL="https://www.youtube.com/@msbuster1903";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(youtubeURL));
                startActivity(intent);
            }
        });


    }
}