package com.ahmed.elmalek.ui.board_screen.view_model;

import android.app.Application;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.ahmed.elmalek.R;
import com.ahmed.elmalek.callBacks.BoardCallBack;
import com.ahmed.elmalek.utils.BaseViewModel;
import com.squareup.picasso.Picasso;

public class BoardViewModel extends BaseViewModel {

    //TODO create 3 object to handle 3 views

    private Context context;
    private BoardCallBack callBack;

    public BoardViewModel(@NonNull Application application) {
        super(application);
    }

    @BindingAdapter("bind:boardKingOneImageUrl")
    public static void loadKingOneImage(ImageView view, String imageURL) {
        Picasso.with(view.getContext()).load(imageURL).into(view);
    }

    @BindingAdapter("bind:boardKingTwoImageUrl")
    public static void loadKIngTwoImage(ImageView view, String imageURL) {
        Picasso.with(view.getContext()).load(imageURL).into(view);
    }

    @BindingAdapter("bind:boardKingExchangeImageUrl")
    public static void loadKingExchangeImage(ImageView view, String imageURL) {
        Picasso.with(view.getContext()).load(imageURL).into(view);
    }

    public void setContextAndCallBackAndGetData(Context context, BoardCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
        getBoardData();
    }

    private void getBoardData() {
        callBack.setDataAndHideLoading();
    }

    public String getKingOneImageUrl() {
        return "";
    }

    public String getKingTwoImageUrl() {
        return "";
    }

    public String getKingExchangeImageUrl() {
        return "";
    }


    public String getKingOneName() {
        return "Salah";
    }

    public String getKingTwoName() {
        return "Reda";
    }

    public String getKingExchangeName() {
        return "Salah";
    }

    public String getKingTwoPoint() {
        return "80 " + context.getString(R.string.points);
    }

    public View.OnClickListener helpKingTwo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }


}
