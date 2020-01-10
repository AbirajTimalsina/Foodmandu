package com.example.foodmandu.bll;

import com.example.foodmandu.api.UsersAPI;
import com.example.foodmandu.serverresponse.SignUpResponse;
import com.example.foodmandu.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {

    boolean isSuccess = false;

    public boolean checkUser(String username,String password){
        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<SignUpResponse> usersCall = usersAPI.checkUser(username,password);
        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if(loginResponse.isSuccessful()){
                Url.token += loginResponse.body().getToken();
                isSuccess = true;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return isSuccess;
    }
}
