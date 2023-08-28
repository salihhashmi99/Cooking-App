package com.example.lovify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lovify.databinding.ActivityChangePasswordBinding;
import com.google.firebase.auth.EmailAuthCredential;

import java.nio.charset.StandardCharsets;

public class ChangePassword extends AppCompatActivity {
    private ActivityChangePasswordBinding binding;
    TextView txtoops, txtchangepassword, txtchangemsg, txtpassword, txtconfirmpassword;
    EditText edtchangepassword, edtconfirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txtoops=findViewById(R.id.txtoops);
        txtchangepassword=findViewById(R.id.txtchangepassword);
        txtchangemsg=findViewById(R.id.txtmsgchangepassword);
        txtpassword=findViewById(R.id.txtnewpassword);
        txtconfirmpassword=findViewById(R.id.txtConfirmPassword);

        edtchangepassword=findViewById(R.id.edtnewpassword);
        edtconfirmpassword=findViewById(R.id.edtConfirmpassword);

        //Add onClick Listener on the Confirm Button
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String changePassword = edtchangepassword.getText().toString().trim();
                String confirmPassword = edtconfirmpassword.getText().toString().trim();

                if (TextUtils.isEmpty(changePassword)){
                    edtchangepassword.setError("Please enter the password");
                    edtchangepassword.requestFocus();
                }
                else if(changePassword.length()<6){
                    edtchangepassword.setError("Password must be 6 character long");
                    edtchangepassword.requestFocus();
                }
                else if (TextUtils.isEmpty(confirmPassword)){
                    edtconfirmpassword.setError("Please confirm your password");
                    edtconfirmpassword.requestFocus();
                }
                else if (confirmPassword.length()>6){
                    edtconfirmpassword.setError("Password must be 6 characters long");
                    edtconfirmpassword.requestFocus();
                }
                else if (!confirmPassword.equals(changePassword)){
                    edtconfirmpassword.setError("Passwords are not matching");
                    edtconfirmpassword.requestFocus();
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), SuccessMessage.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}