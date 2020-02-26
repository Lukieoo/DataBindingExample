package com.anioncode.databindingexample.Connection;
import okhttp3.logging.HttpLoggingInterceptor;
public class LogClass {

    public static HttpLoggingInterceptor getClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return logging;
    }
}