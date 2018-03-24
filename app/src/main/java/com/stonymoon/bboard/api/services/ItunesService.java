package com.stonymoon.bboard.api.services;


import com.stonymoon.bboard.bean.ItunesBean;


import retrofit2.http.GET;
import rx.Observable;


public interface ItunesService {
    @GET("http://120.24.238.200:5000/itunes")
    Observable<ItunesBean> getManagerData();


}
