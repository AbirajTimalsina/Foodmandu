package com.example.foodmandu.model;

public class UsersCUD {

    private String username, Email,Password;

    public UsersCUD(String username, String email, String password) {
        this.username = username;
        Email = email;
        Password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
