package com.example.smoathapplication.models.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.smoathapplication.R;
import com.example.smoathapplication.models.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

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
    List<UserModel> userModelList;
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
                boolean allowToRegister = true;

                username = registrationEditTextUsername.getText().toString();
                password = registrationEditTextPassword.getText().toString();
                confirmPassword = registrationEditTextConfirmPassword.getText().toString();

                if (username.equals("") || username.isEmpty()) {
                    allowToRegister = false;
                    registrationEditTextUsername.setError("you should fill this field");
                }

                if (password.equals("") || password.isEmpty()) {
                    allowToRegister = false;
                    registrationEditTextPassword.setError("you should fill this field");
                }

                if (password.length() < 6 && !password.equals("")) {
                    registrationEditTextPassword.setError("you password should be more then 6");
                    allowToRegister = false;

                }

                if ((confirmPassword.equals("") || confirmPassword.isEmpty()) && registrationButtonLogin.getText().toString().equals("Register")) {
                    registrationEditTextUsername.setError("you should fill this field");
                    allowToRegister = false;
                }


                if ((!password.equals(confirmPassword)) && registrationButtonLogin.getText().toString().equals("Register")) {
                    allowToRegister = false;
                    registrationEditTextPassword.setError("your password doesn't match");
                }

                if (allowToRegister) {
                    if (registrationButtonLogin.getText().toString().equals("Register")) {
                        userModelList = Paper.book().read("USERS", new ArrayList<>());
                        if (userModelList.size() != 0)
                            for (int i = 0; i < userModelList.size(); i++) {
                                if (username.equals(userModelList.get(i).getUsername())) {
                                    Toast.makeText(RegistrationActivity.this, "the user:" + username + "is exited before.", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        UserModel userModel = new UserModel(username, password);
                        userModelList.add(userModel);
                        Paper.book().write("USERS", userModelList);
                        Paper.book().write("USER", userModel);
                        MoveToHome();
                    } else {
                        userModelList = Paper.book().read("USERS", new ArrayList<>());
                        for (int i = 0; i < userModelList.size(); i++) {
                            if (userModelList.get(i).getUsername().equals(username) && userModelList.get(i).getPassword().equals(password)) {
                                Paper.book().write("USER", userModelList.get(i));
                                MoveToHome();
                                return;
                            }
                        }
                        Toast.makeText(RegistrationActivity.this, "this user not existed please register", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    //region Methods
    private void MoveToHome() {
        Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
        RegistrationActivity.this.startActivity(intent);
    }
    //endregion
}