package com.example.smoathapplication.models.home.model;

import android.graphics.drawable.Drawable;

public class OfferModel {

    //region Property
    private String image;
    private String name;
    private String duration;
    private int rating;
    //endregion

    //region Constructor

    public OfferModel(String image, String name, String duration, int rating) {
        this.image = image;
        this.name = name;
        this.duration = duration;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    //endregion
}
