package com.example.smoathapplication.models.home.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SelfResponse {

    @SerializedName("href")
    @Expose
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
