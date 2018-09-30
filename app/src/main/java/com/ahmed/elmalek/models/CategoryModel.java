package com.ahmed.elmalek.models;

public class CategoryModel {


    private String name;
    private String imageURL;
    private String highPercentage;
    private String lowPercentage;

    public CategoryModel(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }

    public CategoryModel(String name, String imageURL, String highPercentage, String lowPercentage) {
        this.name = name;
        this.imageURL = imageURL;
        this.highPercentage = highPercentage;
        this.lowPercentage = lowPercentage;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getHighPercentage() {
        return highPercentage;
    }

    public String getLowPercentage() {
        return lowPercentage;
    }
}
