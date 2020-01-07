package com.example.foodmandu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashActivity extends AwesomeSplash {


    @Override
    public void initSplash(ConfigSplash configSplash) {
        // hide action bar.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // background animation.
        // having a conig parameter, which helps to configure the animated effect on the screen.
        configSplash.setBackgroundColor(R.color.colorAccent);
        configSplash.setAnimCircularRevealDuration(3000);
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);
        configSplash.setRevealFlagX(Flags.REVEAL_BOTTOM);
        // from left hand side buttom it will start the animation.

        // logo
        configSplash.setLogoSplash(R.drawable.foodmandu);

        configSplash.setAnimLogoSplashDuration(2000);
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn);

        //title
        configSplash.setTitleSplash(" Food Mandu");
        configSplash.setTitleTextColor(R.color.white);
        configSplash.setTitleTextSize(30f);
        configSplash.setAnimTitleDuration(1000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
    }

    @Override
    public void animationsFinished() {
        Intent intent = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
