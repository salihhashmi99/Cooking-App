package com.example.lovify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovify.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class Login extends AppCompatActivity {
    TextView txtemail, txtpassword;
    CardView imgfacebook, imggoogle;
    EditText edtemail, edtpassword;
    FirebaseAuth mAuth;

    private ActivityLoginBinding binding; //view binding
    private final static String TAG ="Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth=FirebaseAuth.getInstance();

        //checking the firebase connectivity
        if (FirebaseApp.getApps(this).isEmpty()){
            Toast.makeText(this, "Firebase is not connected", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Firebase connected Successfully", Toast.LENGTH_SHORT).show();
        }

        txtemail=findViewById(R.id.txtEmail);
        txtpassword=findViewById(R.id.txtPassword);
        edtemail=findViewById(R.id.edtEmail);
        edtpassword=findViewById(R.id.edtPassword);
        imgfacebook=findViewById(R.id.facebooklogo);
        imggoogle=findViewById(R.id.googlelogo);

        //Add onClick listener on the txtForget
        binding.txtForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);
                startActivity(intent);
                finish();
            }
        });

        //Add on Click Listener on the txySignUp
        binding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        //Add on click Listener on Loginbtb
        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtemail.getText().toString().trim();
                String password = edtpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    edtemail.setError("Please enter your email address");
                    edtemail.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    edtpassword.setError("Please enter the password");
                    edtpassword.requestFocus();
                    return;
                }
                if (password.length()<6){
                    edtpassword.setError("Password must be 6 characters long");
                    edtpassword.requestFocus();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
//                            Toast.makeText(Login.this, "Login failed", Toast.LENGTH_SHORT).show();
                            try {
                                throw task.getException();
                            }catch (FirebaseAuthInvalidUserException e){
                                edtemail.setError("Invalide User, Please login again");
                                edtemail.requestFocus();
                            }catch (FirebaseAuthInvalidCredentialsException e){
                                edtemail.setError("Invalid Credentials, Please try again");
                                edtemail.requestFocus();
                            }catch (Exception e){
                                Log.e(TAG, e.getMessage());
                                Toast.makeText(Login.this, "Something, wents wrong", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });
    }
}