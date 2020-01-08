package com.example.foodmandu.model;

public class UsersCUD {

    private String username,firstName,lastName,Password,ProfileImage;

    public UsersCUD(String username, String firstName, String lastName, String password, String profileImage) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Password = password;
        this.ProfileImage = profileImage;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UsersCUD(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UsersCUD(String username, String email, String password) {
        this.username = username;

        Password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
