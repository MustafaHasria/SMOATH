package com.example.smoathapplication.models.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smoathapplication.R;
import com.example.smoathapplication.models.home.model.CategoryMovieModel;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryAdapterViewHolder> {

    //region Variables
    MovieAdapter movieAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<CategoryMovieModel> categoryMovieModelList;
    Context context;
    //endregion

    //region Constructor

    public CategoryAdapter(List<CategoryMovieModel> categoryMovieModelList) {
        this.categoryMovieModelList = categoryMovieModelList;
    }

    //endregion

    @NonNull
    @Override
    public CategoryAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_list_item, viewGroup, false);
        context = viewGroup.getContext();
        return new CategoryAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapterViewHolder offerAdapterViewHolder, int i) {
        offerAdapterViewHolder.categoryListItemTextCategory.setText(categoryMovieModelList.get(i).getNameCategory());
        movieAdapter = new MovieAdapter(categoryMovieModelList.get(i).getMovieModelList());
        layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        offerAdapterViewHolder.categoryListItemRecyclerView.setLayoutManager(layoutManager);
        offerAdapterViewHolder.categoryListItemRecyclerView.setAdapter(movieAdapter);
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    //region View holder
    class CategoryAdapterViewHolder extends RecyclerView.ViewHolder {

        //region Components
        ImageView categoryListItemImageShowAll;
        TextView categoryListItemTextCategory;
        RecyclerView categoryListItemRecyclerView;
        //endregion

        public CategoryAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryListItemImageShowAll = itemView.findViewById(R.id.category_list_item_image_show_all);
            categoryListItemTextCategory = itemView.findViewById(R.id.category_list_item_text_category);
            categoryListItemRecyclerView = itemView.findViewById(R.id.category_list_item_recycler_view);
        }
    }
    //endregion
}
