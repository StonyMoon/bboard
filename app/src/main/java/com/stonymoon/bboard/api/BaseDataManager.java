package com.stonymoon.bboard.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseDataManager {
    private static Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl("http://120.24.238.200:4567/")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Retrofit getHttpManager() {
        return mRetrofit;
    }

}
