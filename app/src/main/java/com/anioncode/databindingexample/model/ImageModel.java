package com.anioncode.databindingexample.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;


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

    public String getLikes() {
        return String.valueOf(likes);
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

    @BindingAdapter("image")
    public static  void setImageUrl(ImageView imageView, String url) {

        Picasso.get().load(url).into(imageView);
    }
}
