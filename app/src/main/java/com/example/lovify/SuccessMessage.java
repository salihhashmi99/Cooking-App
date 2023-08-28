package com.example.lovify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lovify.databinding.ActivitySuccessMessageBinding;

import org.w3c.dom.Text;

public class SuccessMessage extends AppCompatActivity {
    TextView txtsuccessheading, txtsuccessmsg, txtPasswordchanged;
    ImageView imageSuccess;

    private ActivitySuccessMessageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySuccessMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txtPasswordchanged=findViewById(R.id.txtpasswordchanged);
        txtsuccessheading=findViewById(R.id.txtSuccessMessage);
        txtsuccessmsg=findViewById(R.id.txtSuccess);

        imageSuccess=findViewById(R.id.imgsuccessmessage);

        binding.btnoK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}