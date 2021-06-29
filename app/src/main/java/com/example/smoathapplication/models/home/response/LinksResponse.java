package com.example.smoathapplication.models.home.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinksResponse {

    @SerializedName("self")
    @Expose
    private SelfResponse self;
    @SerializedName("previousepisode")
    @Expose
    private PreviousepisodeResponse previousepisode;

    public SelfResponse getSelf() {
        return self;
    }

    public void setSelf(SelfResponse self) {
        this.self = self;
    }

    public PreviousepisodeResponse getPreviousepisode() {
        return previousepisode;
    }

    public void setPreviousepisode(PreviousepisodeResponse previousepisode) {
        this.previousepisode = previousepisode;
    }
}
