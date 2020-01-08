package com.example.foodmandu.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.animation.FloatArrayEvaluator;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodmandu.R;
import com.example.foodmandu.api.UsersAPI;
import com.example.foodmandu.model.UsersCUD;
import com.example.foodmandu.serverresponse.ImageResponse;
import com.example.foodmandu.serverresponse.SignUpResponse;
import com.example.foodmandu.strictmode.StrictModeClass;
import com.example.foodmandu.url.Url;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {


    public Button btnReg;
    public TextView tvCacnel;
    public ImageView imgProfile;
    public EditText etFirstname, etLastname, etusername, etPass;
    String imagePath;
    private String imageName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etusername = findViewById(R.id.etRegUname);
        etFirstname = findViewById(R.id.etRegFname);
        etLastname = findViewById(R.id.etRegLname);
        imgProfile = findViewById(R.id.imgProfile);
        etPass = findViewById(R.id.etRegPass);
        btnReg = findViewById(R.id.btnReg);
        tvCacnel = findViewById(R.id.tvCancel);
        tvCacnel.setOnClickListener(this);

        btnReg.setOnClickListener(this);

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseImage();
            }
        });

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);

        Register();
    }


    private void Register() {
        String username = etusername.getText().toString();
        String firstname = etFirstname.getText().toString();
        String lastname = etLastname.getText().toString();
        String password = etPass.getText().toString();


        UsersCUD users = new UsersCUD(username, firstname, lastname, password,imageName);

        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<SignUpResponse> signUpCall = usersAPI.registerUser(users);

        signUpCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                Toast.makeText(SignupActivity.this, "Registered Sucessfully", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void BrowseImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "Please select an image ", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        imgProfile.setImageURI(uri);
        imagePath = getRealPathFromUri(uri);
    }

    private String getRealPathFromUri(Uri uri) {

        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(),
                uri, projection, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(colIndex);
        cursor.close();
        return result;
    }

    private void SaveImageOnly() {
        File file = new File(imagePath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("imageFile",
                file.getName(), requestBody);
        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<ImageResponse> responseBodyCall = usersAPI.uploadImage(body);

        StrictModeClass.StrictMode();

        try{
            Response<ImageResponse> imageResponseResponse = responseBodyCall.execute();
            imageName = imageResponseResponse.body().getFilename();
            Toast.makeText(this, "Image inserted", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error"+ e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}

