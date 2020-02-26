package com.anioncode.databindingexample.model;

import com.google.gson.annotations.SerializedName;

public class UrlModel  {

    @SerializedName("regular")
    String regular;
    @SerializedName("small")
    String small;

    public UrlModel(String regular, String small) {
        this.regular = regular;
        this.small = small;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}
