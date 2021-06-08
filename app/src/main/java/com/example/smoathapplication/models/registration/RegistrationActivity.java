package com.example.smoathapplication.models.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.smoathapplication.R;

public class RegistrationActivity extends AppCompatActivity {

    //region Components
    EditText registrationEditTextUsername;
    EditText registrationEditTextPassword;
    EditText registrationEditTextConfirmPassword;
    Button registrationButtonLogin;
    Button registrationButtonSignUp;
    //endregion

    //region Variables
    String username;
    String password;
    String confirmPassword;
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        registrationEditTextUsername = findViewById(R.id.registration_edit_text_username);
        registrationEditTextPassword = findViewById(R.id.registration_edit_text_password);
        registrationEditTextConfirmPassword = findViewById(R.id.registration_edit_text_confirm_password);
        registrationButtonLogin = findViewById(R.id.registration_button_login);
        registrationButtonSignUp = findViewById(R.id.registration_button_sign_up);


        registrationButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (registrationButtonSignUp.getText().toString().equals("Register")) {
                    registrationButtonLogin.setText("Register");
                    registrationEditTextConfirmPassword.setVisibility(View.VISIBLE);
                    registrationButtonSignUp.setText("Login");
                } else {
                    registrationButtonLogin.setText("Login");
                    registrationEditTextConfirmPassword.setVisibility(View.GONE);
                    registrationButtonSignUp.setText("Register");

                }

            }
        });

        registrationButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = registrationEditTextUsername.getText().toString();
                password = registrationEditTextPassword.getText().toString();
                confirmPassword = registrationEditTextConfirmPassword.getText().toString();

                if (username.equals("") || username.isEmpty())
                    registrationEditTextUsername.setError("you should fill this field");

                if (password.equals("") || password.isEmpty())
                    registrationEditTextUsername.setError("you should fill this field");

                if ((confirmPassword.equals("") || confirmPassword.isEmpty()) && registrationButtonLogin.getText().toString().equals("Register"))
                    registrationEditTextUsername.setError("you should fill this field");

                if (password.length() < 6)
                    registrationEditTextPassword.setError("you password should be more then 6");

                if ((password != confirmPassword) && registrationButtonLogin.getText().toString().equals("Register"))
                    registrationEditTextPassword.setError("your password doesn't match");



                if (registrationButtonLogin.getText().toString().equals("Register")) {
                    } else {
                    }
            }
        });
    }
}