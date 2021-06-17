package com.example.smoathapplication.models.home.adapter;

import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smoathapplication.R;
import com.example.smoathapplication.models.home.model.MovieModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    //region Variables
    List<MovieModel> movieModelList;
    //endregion

    //region Constructor

    public MovieAdapter(List<MovieModel> movieModelList) {
        this.movieModelList = movieModelList;
    }

    //endregion

    @NonNull
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list_item, viewGroup, false);
        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterViewHolder offerAdapterViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    //region View holder
    class MovieAdapterViewHolder extends RecyclerView.ViewHolder {

        //region Components
        CardView movieListItemCardMainContainer;
        TextView movieListItemTextName;
        //endregion

        public MovieAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            movieListItemCardMainContainer = itemView.findViewById(R.id.movie_list_item_card_main_container);
            movieListItemTextName = itemView.findViewById(R.id.movie_list_item_text_name);
        }
    }
    //endregion
}
