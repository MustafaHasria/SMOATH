package com.example.smoathapplication.models.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.smoathapplication.R;
import com.example.smoathapplication.models.home.HomeActivity;
import com.example.smoathapplication.models.registration.RegistrationActivity;
import com.example.smoathapplication.models.registration.UserModel;

import io.paperdb.Paper;

public class SplashActivity extends AppCompatActivity {

    //region Variables
    UserModel userModel;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Paper.init(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userModel = Paper.book().read("USER");
                if (userModel == null) {
                    Intent intent = new Intent(SplashActivity.this, RegistrationActivity.class);
                    SplashActivity.this.startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    SplashActivity.this.startActivity(intent);
                    finish();
                }
            }
        }, 1000);
    }
}