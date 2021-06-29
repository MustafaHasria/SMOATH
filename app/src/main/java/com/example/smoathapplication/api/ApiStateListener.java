package com.example.smoathapplication.api;

public interface ApiStateListener {

    void onSuccess(Object... params);

    void onFailure(Object... params);
}
