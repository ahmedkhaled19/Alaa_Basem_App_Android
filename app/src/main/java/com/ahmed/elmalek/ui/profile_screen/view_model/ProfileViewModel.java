package com.ahmed.elmalek.ui.profile_screen.view_model;

import android.app.Application;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.ahmed.elmalek.callBacks.ProfileCallBack;
import com.ahmed.elmalek.models.NotificationModel;
import com.ahmed.elmalek.utils.BaseViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProfileViewModel extends BaseViewModel {

    private Context context;
    private ProfileCallBack callBack;
    public ProfileViewModel(@NonNull Application application) {
        super(application);
    }

    @BindingAdapter("bind:profileImageUrl")
    public static void loadImage(ImageView view, String imageURL) {
        Picasso.with(view.getContext()).load(imageURL).into(view);
    }

    public void setContextAndsetCallBackAndGetData(Context context, ProfileCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
        getNotificationData();
    }

    private void getNotificationData() {
        List<NotificationModel> list = new ArrayList<>();
        list.add(new NotificationModel("Reda Send you 10 points", ""));
        list.add(new NotificationModel("Reda Send you 20 points", ""));
        list.add(new NotificationModel("Reda Send you 30 points", ""));
        callBack.setNotificationData(list);
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
