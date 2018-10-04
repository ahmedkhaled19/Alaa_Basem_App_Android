package com.ahmed.elmalek.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ah.khaled1994@gmail.com on 2018-09-16.
 */
public class ImageSlider {

    @SerializedName("url")
    private String url;

    @SerializedName("image_url")
    private String imageUrl;

    public ImageSlider(String url, String imageUrl) {
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
