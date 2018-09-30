package com.ahmed.elmalek.ui.splash_screen;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.ahmed.elmalek.R;
import com.ahmed.elmalek.utils.SharedPrefreanceManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPrefreanceManager.getInstance().initializeSharedData(this);
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

    }
}

