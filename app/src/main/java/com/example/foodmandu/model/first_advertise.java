package com.example.foodmandu.model;

public class first_advertise {

    private String position;
    private int firstimage;
    private int secondimage;
    private String title;
    private String country;
    private String location;

    public first_advertise(String position, int firstimage, int secondimage, String title, String country, String location) {
        this.position = position;
        this.firstimage = firstimage;
        this.secondimage = secondimage;
        this.title = title;
        this.country = country;
        this.location = location;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getFirstimage() {
        return firstimage;
    }

    public void setFirstimage(int firstimage) {
        this.firstimage = firstimage;
    }

    public int getSecondimage() {
        return secondimage;
    }

    public void setSecondimage(int secondimage) {
        this.secondimage = secondimage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
