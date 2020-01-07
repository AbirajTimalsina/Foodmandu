package com.example.foodmandu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.FloatArrayEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodmandu.R;
import com.example.foodmandu.api.UsersAPI;
import com.example.foodmandu.model.UsersCUD;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    public String BASE_URL = "https://10.0.0.2:3000";
    private Button btnCancel,btnReg;
    private EditText etusername, etEmail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnCancel = findViewById(R.id.btnCancel);
        etusername = findViewById(R.id.etusername);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPassword);
        btnReg = findViewById(R.id.btnRegister);

        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
        startActivity(intent);

        Register();
    }

    private void Register(){
        String username = etusername.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();

        UsersCUD users = new UsersCUD(username,email,password);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create()).build();

        UsersAPI usersAPI = retrofit.create(UsersAPI.class);
        Call<Void> voidCall = usersAPI.registerUser(users);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(SignupActivity.this, "Registered Sucessfully", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
