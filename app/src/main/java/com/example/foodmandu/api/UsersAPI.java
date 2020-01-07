package com.example.foodmandu.api;

import com.example.foodmandu.model.UsersCUD;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UsersAPI {

@POST("users")
    Call<Void>registerUser(@Body UsersCUD users);


}
