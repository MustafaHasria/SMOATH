package com.example.smoathapplication.models.home.model;

import android.graphics.drawable.Drawable;

public class MovieModel {

    //region Property
    private String image;
    private String name;
    private String duration;
    private String category;
    private float rating;
    //endregion

    //region Constructor

    public MovieModel() {
    }

    public MovieModel(String image, String name, String duration, String category, float rating) {
        this.image = image;
        this.name = name;
        this.duration = duration;
        this.category = category;
        this.rating = rating;
    }


    //endregion

    //region Getters & Setters

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    //endregion
}
