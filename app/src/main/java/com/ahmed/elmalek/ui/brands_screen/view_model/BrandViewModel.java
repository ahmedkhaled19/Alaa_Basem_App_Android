package com.ahmed.elmalek.ui.brands_screen.view_model;

import android.app.Application;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.ahmed.elmalek.callBacks.BrandProfileCallBack;
import com.ahmed.elmalek.utils.BaseViewModel;
import com.squareup.picasso.Picasso;

public class BrandViewModel extends BaseViewModel {


    private Context context;
    private BrandProfileCallBack callBack;

    public BrandViewModel(@NonNull Application application) {
        super(application);
    }

    @BindingAdapter("bind:brandImageUrl")
    public static void loadImage(ImageView view, String imageURL) {
        Picasso.with(view.getContext()).load(imageURL).into(view);
    }

    public void setContextAndCallBackAndGetData(String brandID, Context context, BrandProfileCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
        getBrandProfile(brandID);
    }

    private void getBrandProfile(String brandID) {
        callBack.setViewModel();
    }

    public String getBrandName() {
        return "Macdonald";
    }

    public String getBrandRate() {
        return "3.5";
    }

    public String getURL() {
        return "https://i.ytimg.com/vi/1CeCFqeDYuM/maxresdefault.jpg";
    }


}

