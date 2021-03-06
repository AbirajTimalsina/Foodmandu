package com.example.foodmandu.api;

import android.media.ImageReader;

import com.example.foodmandu.model.UsersCUD;
import com.example.foodmandu.model.first_advertise;
import com.example.foodmandu.serverresponse.ImageResponse;
import com.example.foodmandu.serverresponse.SignUpResponse;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UsersAPI {


    @POST("users/signup")
    Call<SignUpResponse>registerUser(@Body UsersCUD users);

    @FormUrlEncoded
    @POST("users/login")
    Call<SignUpResponse>checkUser(@Field("username") String username, @Field("password")String password);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("users/me")
    Call<UsersCUD> getUserDetails(@Header("Authorization")String token);

    @GET("adver/all")
    Call<List<first_advertise>> getAdvertise();





}
