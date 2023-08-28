package com.example.lovify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovify.databinding.ActivityForgetPasswordBinding;
import com.example.lovify.utils.Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import java.util.function.Consumer;

public class ForgetPassword extends AppCompatActivity {
    private ActivityForgetPasswordBinding binding;
    TextView txtforgetpassword, txtmessage, txtEmailaddress;
    EditText edtemailaddress;
    ProgressDialog dialogue;
    FirebaseAuth mAuth;
    private final static String TAG= "ForgetPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txtEmailaddress=findViewById(R.id.txtnewpassword);
        txtforgetpassword=findViewById(R.id.txtforgetpassword);
        txtmessage=findViewById(R.id.txtmsgforget);
        edtemailaddress=findViewById(R.id.edtemailaddress);

        mAuth=FirebaseAuth.getInstance();

        dialogue=new ProgressDialog(ForgetPassword.this);
        dialogue.setCancelable(false);
        dialogue.setMessage(".....Loading");

        //Add onClick Listener on the Confirm Button
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailaddress = edtemailaddress.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (TextUtils.isEmpty(emailaddress)){
                    edtemailaddress.setError("Please provide the Email Address for which you want to change the password");
                    edtemailaddress.requestFocus();
                    return;
                }
                else if(!emailaddress.matches(emailPattern)){
                    edtemailaddress.setError("Enter the valid Email Address");
                    edtemailaddress.requestFocus();
                    return;
                }
                else
                {
                    edtemailaddress.setError(null);
                }

                mAuth.sendPasswordResetEmail(emailaddress).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        dialogue.dismiss();
                        if (task.isSuccessful()){
                            Toast.makeText(ForgetPassword.this, "You can change your password now", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),ChangePassword.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthInvalidUserException e){
                                edtemailaddress.setError("User does not exist. Please try again");
                                edtemailaddress.requestFocus();
                            } catch (Exception e){
                                Log.e(TAG, e.getMessage());
                                Toast.makeText(ForgetPassword.this, "Something wrong, try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ForgetPassword.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

//        private Boolean validateEmail(){
//
//        }

        //Add onClick Listerner on the btnCancel
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ForgetPassword.this, "Back to the login page", Toast.LENGTH_SHORT).show();
                new Utils().alert(ForgetPassword.this, "Cancel", "Are you sure?", new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) {
                        if (aBoolean){
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {

                        }
                    }
                });
            }
        });
    }
}