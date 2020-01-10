package com.example.foodmandu.model;

import androidx.annotation.VisibleForTesting;

public class Contacts {

    private String name;
    private int imageBtn;

    public Contacts(String name, int imageBtn) {
        this.name = name;
        this.imageBtn = imageBtn;
    }

    public String getCatName() {
        return name;
    }

    public void setCatName(String catName) {
        name = catName;
    }

    public int getImageBtn() {
        return imageBtn;
    }

    public void setImageBtn(int imageBtn) {
        this.imageBtn = imageBtn;
    }
}
