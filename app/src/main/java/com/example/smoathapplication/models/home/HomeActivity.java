package com.example.smoathapplication.models.home;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smoathapplication.R;
import com.example.smoathapplication.api.ApiStateListener;
import com.example.smoathapplication.models.addmovie.AddMovieActivity;
import com.example.smoathapplication.models.home.adapter.CategoryAdapter;
import com.example.smoathapplication.models.home.adapter.MovieAdapter;
import com.example.smoathapplication.models.home.adapter.OfferAdapter;
import com.example.smoathapplication.models.home.caller.MovieCaller;
import com.example.smoathapplication.models.home.model.CategoryMovieModel;
import com.example.smoathapplication.models.home.modelapi.ImageModel;
import com.example.smoathapplication.models.home.modelapi.MovieModel;
import com.example.smoathapplication.models.home.response.MovieResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity implements OfferAdapter.OfferAdapterClickListeners {

    //region Components
    RecyclerView homeRecyclerOffer;
    RecyclerView homeRecyclerCategory;
    FloatingActionButton homeFloatingActionButtonAdd;
    ImageView homeImageViewInfo;
    AVLoadingIndicatorView homeProgressBar;
    //endregion

    //region Variables
    OfferAdapter offerAdapter;
    CategoryAdapter categoryAdapter;
    MovieAdapter movieAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<MovieModel> offerModelList;
    List<CategoryMovieModel> categoryMovieModelList;
    MovieCaller movieCaller;
    //endregion

    //region Lifecycle
    @Override
    protected void onResume() {
        super.onResume();
        offerAdapter.updateList(Paper.book().read("MOVIES_LIST", new ArrayList<>()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        movieCaller = new MovieCaller();
        homeRecyclerOffer = findViewById(R.id.home_recycler_offer);
        homeRecyclerCategory = findViewById(R.id.home_recycler_category);
        homeFloatingActionButtonAdd = findViewById(R.id.home_floating_action_button_add);
        homeImageViewInfo = findViewById(R.id.home_image_view_info);
        homeProgressBar = findViewById(R.id.home_progress_bar);

        offerModelList = Paper.book().read("MOVIES_LIST", new ArrayList<>());
        categoryMovieModelList = Paper.book().read("CATEGORY_MODEL_LIST", new ArrayList<>());

        movieCaller.connectToGetAllMoviesApi(new ApiStateListener() {
            @Override
            public void onSuccess(Object... params) {
                List<MovieResponse> movieResponses;
                movieResponses = (List<MovieResponse>) params[0];
                offerModelList = new ArrayList<>();
                for (int i = 0; i < movieResponses.size(); i++) {
                    MovieModel movieModel =new MovieModel();
                    movieModel.setId(movieResponses.get(i).getId());
                    movieModel.setAverageRuntime(movieResponses.get(i).getAverageRuntime());
                    movieModel.setGenres(movieResponses.get(i).getGenres());
                    ImageModel imageModel = new ImageModel();
                    imageModel.setMedium(movieResponses.get(i).getImage().getMedium());
                    imageModel.setOriginal(movieResponses.get(i).getImage().getOriginal());
                    movieModel.setImage(imageModel);
                    movieModel.setLanguage(movieResponses.get(i).getLanguage());
                    movieModel.setName(movieResponses.get(i).getName());
                    movieModel.setOfficialSite(movieResponses.get(i).getOfficialSite());
                    movieModel.setPremiered(movieResponses.get(i).getPremiered());
                    movieModel.setRuntime(movieResponses.get(i).getRuntime());
                    movieModel.setStatus(movieResponses.get(i).getStatus());
                    movieModel.setSummary(movieResponses.get(i).getSummary());
                    movieModel.setType(movieResponses.get(i).getType());
                    movieModel.setUrl(movieResponses.get(i).getUrl());
                    offerModelList.add(movieModel);
                }
                homeProgressBar.setVisibility(View.GONE);
                offerAdapter.updateList(offerModelList);

            }

            @Override
            public void onFailure(Object... params) {

            }
        });
        setupOfferRecyclerView();
        setupCategoryRecyclerView();

        homeImageViewInfo.setOnClickListener(v -> {
            Dialog dialog = new Dialog(HomeActivity.this);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setContentView(R.layout.developer_team_info_dialog);
            Button developerTeamInfoDialogButtonOk = dialog.findViewById(R.id.developer_team_info_dialog_button_ok);
            developerTeamInfoDialogButtonOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        });
        homeFloatingActionButtonAdd.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, AddMovieActivity.class)));

    }
    //endregion

    //region Setup Recyclers
    private void setupOfferRecyclerView() {
        offerAdapter = new OfferAdapter(offerModelList, this);
        layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        homeRecyclerOffer.setLayoutManager(layoutManager);
        homeRecyclerOffer.setAdapter(offerAdapter);
    }

    private void setupCategoryRecyclerView() {
        categoryAdapter = new CategoryAdapter(categoryMovieModelList);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        homeRecyclerCategory.setLayoutManager(layoutManager);
        homeRecyclerCategory.setAdapter(offerAdapter);
    }


    //endregion

    //region Adapter listener
    @Override
    public void onOfferListItemCardMainContainerLongClickListener(MovieModel movieModel, int position) {
        Dialog dialog = new Dialog(HomeActivity.this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.brief_movie_dialog);
        ImageView briefMovieDialogImageClose = dialog.findViewById(R.id.brief_movie_dialog_image_close);
        briefMovieDialogImageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    //endregion
}