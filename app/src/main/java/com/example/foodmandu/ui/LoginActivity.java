package com.example.foodmandu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodmandu.MainActivity;
import com.example.foodmandu.R;
import com.example.foodmandu.bll.LoginBLL;
import com.example.foodmandu.strictmode.StrictModeClass;
import com.example.foodmandu.ui.More.MoreFragment;
import com.example.foodmandu.ui.myBasket.MyBasketFragment;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail,etPassword;
    private TextView tvReg;
    private Button btnLogin, btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etLogEmail);
        etPassword = findViewById(R.id.etLogPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnBack = findViewById(R.id.btnBack);
        tvReg = findViewById(R.id.tvReg);

        btnBack.setOnClickListener(this);
        tvReg.setOnClickListener(this);

//            etEmail.setText("raj123");
//            etPassword.setText("raj123");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        LoginBLL loginBLL = new LoginBLL();

        StrictModeClass.StrictMode();
        if(loginBLL.checkUser(email,password)){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "Username or password incorrect", Toast.LENGTH_LONG).show();
            etEmail.requestFocus();
        }
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
        startActivity(intent);

        Intent intent1 = new Intent(LoginActivity.this, MyBasketFragment.class);
        startActivity(intent);
    }
}
