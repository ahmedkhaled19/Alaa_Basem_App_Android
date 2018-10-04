package com.ahmed.elmalek.ui.home_screen.view_model;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.ahmed.elmalek.models.ImageSlider;
import com.ahmed.elmalek.utils.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import in.myinnos.imagesliderwithswipeslibrary.Animations.DescriptionAnimation;
import in.myinnos.imagesliderwithswipeslibrary.SliderLayout;
import in.myinnos.imagesliderwithswipeslibrary.SliderTypes.BaseSliderView;
import in.myinnos.imagesliderwithswipeslibrary.SliderTypes.DefaultSliderView;

public class HomeViewModel extends BaseViewModel {

    private Context context;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void setContextAndGetSliderImageData(Context context, SliderLayout sliderLayout) {
        this.context = context;
        getBannerData(sliderLayout);
    }

    private void getBannerData(SliderLayout sliderLayout) {
        List<ImageSlider> imageSliders = new ArrayList<>();
        imageSliders.add(new ImageSlider("", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtSP-scAGJSJoA_BITscisDtmm7Detf6Dar5RqiepYw0x6H7itcQ"));
        imageSliders.add(new ImageSlider("", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT15RnuR4yTNW2GTNfUq4uzXEwlca9Cm5jN079X7HoGO9FaW-lJ5A"));
        imageSliders.add(new ImageSlider("", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9ZkSWjHS3YyFcJipVEA07-5MOLk_SMZOtrS-F2o7Fam8H9JzB3w"));
        setImageIntoSlider(sliderLayout, imageSliders);
    }

    private void setImageIntoSlider(SliderLayout sliderLayout, List<ImageSlider> body) {
        for (int i = 0; i < body.size(); i++) {
            DefaultSliderView defaultSliderView = new DefaultSliderView(context);
            defaultSliderView
                    .image(body.get(i).getImageUrl())
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            sliderLayout.addSlider(defaultSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
    }
}
