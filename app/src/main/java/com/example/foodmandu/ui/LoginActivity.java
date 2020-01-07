package com.example.foodmandu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.foodmandu.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvReg = findViewById(R.id.tvReg);
        tvReg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
        startActivity(intent);
    }
}
