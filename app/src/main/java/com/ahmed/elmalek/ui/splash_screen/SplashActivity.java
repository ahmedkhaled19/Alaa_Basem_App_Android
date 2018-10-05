package com.ahmed.elmalek.ui.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.ahmed.elmalek.R;
import com.ahmed.elmalek.ui.home_screen.view.HomeActivity;
import com.ahmed.elmalek.utils.SharedPreferenceManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        SharedPreferenceManager.getInstance().initializeSharedData(this);
        startSplash();
    }

    private void startSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                handelWorkThrough();
            }
        }, 3000);
    }

    private void handelWorkThrough() {
        startActivity(new Intent(this, HomeActivity.class));
    }
}

