package com.example.smoathapplication.models.home.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExternalsResponse {

    @SerializedName("tvrage")
    @Expose
    private int tvrage;
    @SerializedName("thetvdb")
    @Expose
    private int thetvdb;
    @SerializedName("imdb")
    @Expose
    private String imdb;

    public int getTvrage() {
        return tvrage;
    }

    public void setTvrage(int tvrage) {
        this.tvrage = tvrage;
    }

    public int getThetvdb() {
        return thetvdb;
    }

    public void setThetvdb(int thetvdb) {
        this.thetvdb = thetvdb;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }
}
