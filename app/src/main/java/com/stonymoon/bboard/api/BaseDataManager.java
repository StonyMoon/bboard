package com.stonymoon.bboard.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseDataManager {
    private static Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl("https://acharts.co/")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(RankConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Retrofit getHttpManager() {
        return mRetrofit;
    }

}
