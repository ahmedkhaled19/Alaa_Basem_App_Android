package com.ahmed.elmalek.utils;

import android.content.Context;

import com.orhanobut.hawk.Hawk;

public class SharedPrefreanceManager {
    private static final SharedPrefreanceManager ourInstance = new SharedPrefreanceManager();

    public static SharedPrefreanceManager getInstance() {
        return ourInstance;
    }

    private SharedPrefreanceManager() {
    }

    public void initializeSharedData(Context context) {
        Hawk.init(context);
    }
}
