package com.ahmed.elmalek.ui.profile_screen.view_model;

import android.app.Application;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.ahmed.elmalek.utils.BaseViewModel;
import com.squareup.picasso.Picasso;

public class ProfileViewModel extends BaseViewModel {

    private Context context;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
    }

    @BindingAdapter("bind:profileImageUrl")
    public static void loadImage(ImageView view, String imageURL) {
        Picasso.with(view.getContext()).load(imageURL).into(view);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getImageUrl() {
        return "";
    }

    public String getProfileName() {
        return "Mohamed Salah";
    }

    public String getProfileUserName() {
        return "@MoSalah";
    }

    public String getProfilePromoCode() {
        return "ah221194";
    }

    public String getProfileTotalPoints() {
        return "100";
    }

    public String getProfileUsedPoints() {
        return "40";
    }

    public String getProfileRemainPoints() {
        return "60";
    }
}
