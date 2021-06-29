package com.example.smoathapplication.models.home.caller;


import com.example.smoathapplication.api.ApiClient;
import com.example.smoathapplication.api.ApiStateListener;
import com.example.smoathapplication.api.endpoints.MovieApis;
import com.example.smoathapplication.models.home.response.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieCaller {

    //region Variables
    MovieApis movieApis;
    Call<List<MovieResponse>> movieResponseCall;
    //endregion

    //region Constructor

    public MovieCaller() {
        movieApis = ApiClient.getAPIClient().create(MovieApis.class);
    }
    //endregion

    //region Get all movies
    public void connectToGetAllMoviesApi(final ApiStateListener apiStateListener){
        movieResponseCall = movieApis.getMovies();
        movieResponseCall.enqueue(new Callback<List<MovieResponse>>() {
            @Override
            public void onResponse(Call<List<MovieResponse>> call, Response<List<MovieResponse>> response) {
                if (response.body() == null){
                    apiStateListener.onFailure(700);
                } else {
                    if (response.code() == 200){
                        apiStateListener.onSuccess(response.body());
                    } else
                        apiStateListener.onFailure(response.code());
                }
            }

            @Override
            public void onFailure(Call<List<MovieResponse>> call, Throwable t) {
                apiStateListener.onFailure(null);
            }
        });
    }
    //endregion
}
