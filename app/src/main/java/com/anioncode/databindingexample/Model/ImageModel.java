package com.anioncode.databindingexample.Model;

import com.google.gson.annotations.SerializedName;

public class ImageModel {

    @SerializedName("description")
    String description;

    @SerializedName("likes")
    int likes;

    @SerializedName("urls")
    UrlModel urls;

    public ImageModel(String description, int likes, UrlModel urls) {
        this.description = description;
        this.likes = likes;
        this.urls = urls;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public UrlModel getUrls() {
        return urls;
    }

    public void setUrls(UrlModel urls) {
        this.urls = urls;
    }
}
