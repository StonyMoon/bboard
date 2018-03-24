package com.stonymoon.bboard.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public class AchartsManager {
    private static Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl("https://acharts.co/")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(RankConverterFactory.create())
            .build();

    public static Retrofit getHttpManager() {
        return mRetrofit;
    }
}
