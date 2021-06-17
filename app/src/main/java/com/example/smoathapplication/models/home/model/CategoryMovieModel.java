package com.example.smoathapplication.models.home.model;

import java.util.List;

public class CategoryMovieModel {
    //region Property
    private String nameCategory;
    private List<MovieModel> movieModelList;
    //endregion

    //region Constructor

    public CategoryMovieModel(String nameCategory, List<MovieModel> movieModelList) {
        this.nameCategory = nameCategory;
        this.movieModelList = movieModelList;
    }

    //endregion

    //region Getters & Setters

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<MovieModel> getMovieModelList() {
        return movieModelList;
    }

    public void setMovieModelList(List<MovieModel> movieModelList) {
        this.movieModelList = movieModelList;
    }

    //endregion


}
