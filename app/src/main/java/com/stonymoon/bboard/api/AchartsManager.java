package com.stonymoon.bboard.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AchartsManager {
    private static Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl("https://acharts.co/callback/GraphData")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    public static Retrofit getHttpManager() {
        return mRetrofit;
    }
}
