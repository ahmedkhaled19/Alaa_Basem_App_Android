package com.ahmed.elmalek.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import me.anwarshahriar.calligrapher.Calligrapher;

public class GeneralMethods {

    public static void changeItemFont(final View view) {
        Calligrapher calligrapher = new Calligrapher(view.getContext());
        calligrapher.setFont(view, "fonts/BurbankBigCondensed-Black.otf");
    }

    public static void changeViewFont(final Context context) {
        new Thread() {
            public void run() {
                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Calligrapher calligrapher = new Calligrapher(context);
                        calligrapher.setFont(((Activity) context), "fonts/BurbankBigCondensed-Black.otf", true);
                    }
                });
            }
        }.start();
    }
}
