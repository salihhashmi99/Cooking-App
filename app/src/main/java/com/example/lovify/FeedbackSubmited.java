package com.example.lovify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lovify.databinding.ActivityFeedbackSubmitedBinding;

public class FeedbackSubmited extends AppCompatActivity {
    TextView txtsuccessheading, txtsuccessmsg, txtPasswordchanged;
    ImageView imageSuccess;

    ActivityFeedbackSubmitedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFeedbackSubmitedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txtPasswordchanged=findViewById(R.id.txtpasswordchanged);
        txtsuccessheading=findViewById(R.id.txtSuccessMessage);
        txtsuccessmsg=findViewById(R.id.txtSuccess);

        imageSuccess=findViewById(R.id.imgsuccessmessage);

        //Add on click listener on the Ok btn
        binding.btnoK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });


    }
}