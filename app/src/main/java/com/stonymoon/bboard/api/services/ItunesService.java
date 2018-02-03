package com.stonymoon.bboard.api.services;


import com.stonymoon.bboard.bean.ItunesBean;


import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2018/2/3.
 */

public interface ItunesService {
    @GET("/itunes")
    Observable<ItunesBean> getManagerData();


}
