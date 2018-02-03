package com.stonymoon.bboard.api;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/2/3.
 */

public class BaseDataManager {
    private static Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl("http://120.24.238.200:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Retrofit getHttpManager() {
        return mRetrofit;
    }


}
