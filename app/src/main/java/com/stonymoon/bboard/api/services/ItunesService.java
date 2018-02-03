package com.stonymoon.bboard.api.services;

import com.stonymoon.bboard.bean.ItunesBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/2/3.
 */

public interface ItunesService {
    @GET("/itunes")
    Call<ItunesBean> getManagerData();


}
