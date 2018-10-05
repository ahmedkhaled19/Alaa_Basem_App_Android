package com.ahmed.elmalek.utils;

import android.content.Context;

import com.orhanobut.hawk.Hawk;

public class SharedPreferenceManager {
    private static final SharedPreferenceManager ourInstance = new SharedPreferenceManager();

    private SharedPreferenceManager() {
    }

    public static SharedPreferenceManager getInstance() {
        return ourInstance;
    }

    public void initializeSharedData(Context context) {
        Hawk.init(context);
    }
}
