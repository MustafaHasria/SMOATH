package com.example.smoathapplication.models.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.smoathapplication.R;

public class HomeActivity extends AppCompatActivity {
    //region Components
    RecyclerView homeRecyclerOffer;
    RecyclerView homeRecyclerCategory;
    //endregion



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeRecyclerOffer = findViewById(R.id.home_recycler_offer);
        homeRecyclerCategory = findViewById(R.id.home_recycler_category);
    }
}