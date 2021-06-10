package com.example.smoathapplication.models.registration;

public class UserModel {

    //region Property
    private String username;
    private String password;
    //endregion

    //region Constructor
    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
    //endregion

    //region Getters & Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //endregion
}
