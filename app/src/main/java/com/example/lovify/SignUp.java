package com.example.lovify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.example.lovify.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.ktx.Firebase;

public class SignUp extends AppCompatActivity {
    TextView txtcreateAccount, txtname, txtemail, txtpassword, txtconfirmpassword;
    EditText edtname, edtemail, edtpassword, edtConfirmpassword;
    FirebaseAuth mAuth;
    private static final String TAG = "SignUp";
    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Check if Firebase is initialized
        if(FirebaseApp.getApps(this).isEmpty()){
            Toast.makeText(this, "Firebase is not connected", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Firebase is connected Successfully", Toast.LENGTH_SHORT).show();
        }

        mAuth=FirebaseAuth.getInstance(); //database intialization

        txtcreateAccount=findViewById(R.id.txtWelcome);
        txtname=findViewById(R.id.txtName);
        txtemail=findViewById(R.id.txtEmail);
        txtpassword=findViewById(R.id.txtPassword);
        txtconfirmpassword=findViewById(R.id.txtconfirmpassword);

        edtname=findViewById(R.id.edtName);
        edtemail=findViewById(R.id.edtEmail);
        edtpassword=findViewById(R.id.edtPassword);
        edtConfirmpassword=findViewById(R.id.edtconfirmpassword);

        //Add onClickListerner on the SignUp Button
        binding.btnsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtname.getText().toString().trim();
                String email = edtemail.getText().toString().trim();
                String password = edtpassword.getText().toString().toLowerCase().trim();
                String confirmpassword= edtConfirmpassword.getText().toString().toLowerCase().trim();

                if (TextUtils.isEmpty(name)){
                    edtname.setError("Please enter your name");
                    edtname.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(email)){
                    edtemail.setError("Enter yout Email");
                    edtemail.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    edtpassword.setError("Enter the password");
                    edtpassword.requestFocus();
                    return;
                }
                if (password.length()<6){
                    edtpassword.setError("Password must be 6 characters long");
                    edtpassword.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(confirmpassword)){
                    edtConfirmpassword.setError("Please confirm your password");
                    edtConfirmpassword.requestFocus();
                    return;
                }
                if(!password.equals(confirmpassword)){
                    edtConfirmpassword.setError("Passwords are not same, Please check");
                    edtConfirmpassword.requestFocus();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignUp.this, "Account Successfully created", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
//                            Toast.makeText(SignUp.this, "SignUp Failed ", Toast.LENGTH_SHORT).show();
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthWeakPasswordException e){
                                edtpassword.setError("Your Password is week, try strong password");
                                edtpassword.requestFocus();
                            } catch (FirebaseAuthInvalidCredentialsException e){
                                edtpassword.setError("Email is invalid or Already used, Kindly check");
                                edtpassword.requestFocus();
                            } catch (FirebaseAuthUserCollisionException e){
                                edtpassword.setError("User already exist, use another email");
                                edtpassword.requestFocus();
                            } catch (Exception e){
                                Log.e(TAG, e.getMessage());
                                Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });
    }
}