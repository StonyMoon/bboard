package com.stonymoon.bboard.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
/*
发送请求的封装方法

 */


public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);

    }

    public static void postOkHttpRequest(String address, RequestBody requestBody, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);

    }


}
