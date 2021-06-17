package com.example.smoathapplication.models.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.smoathapplication.R;
import com.example.smoathapplication.models.home.adapter.CategoryAdapter;
import com.example.smoathapplication.models.home.adapter.MovieAdapter;
import com.example.smoathapplication.models.home.adapter.OfferAdapter;
import com.example.smoathapplication.models.home.model.CategoryMovieModel;
import com.example.smoathapplication.models.home.model.MovieModel;
import com.example.smoathapplication.models.home.model.OfferModel;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity {

    //region Components
    RecyclerView homeRecyclerOffer;
    RecyclerView homeRecyclerCategory;
    //endregion

    //region Variables
    OfferAdapter offerAdapter;
    CategoryAdapter categoryAdapter;
    MovieAdapter movieAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<OfferModel> offerModelList;
    List<CategoryMovieModel> categoryMovieModelList;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeRecyclerOffer = findViewById(R.id.home_recycler_offer);
        homeRecyclerCategory = findViewById(R.id.home_recycler_category);
        offerModelList = Paper.book().read("OFFER_LIST", new ArrayList<>());
        categoryMovieModelList = Paper.book().read("CATEGORY_MODEL_LIST", new ArrayList<>());

        setupOfferRecyclerView();
        setupCategoryRecyclerView();
    }

    //region Setup Recyclers
    private void setupOfferRecyclerView(){
        offerAdapter = new OfferAdapter(offerModelList);
        layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        homeRecyclerOffer.setLayoutManager(layoutManager);
        homeRecyclerOffer.setAdapter(offerAdapter);
    }

    private void setupCategoryRecyclerView(){
        categoryAdapter = new CategoryAdapter(categoryMovieModelList);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        homeRecyclerCategory.setLayoutManager(layoutManager);
        homeRecyclerCategory.setAdapter(offerAdapter);
    }
    //endregion
}