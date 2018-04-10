package com.stonymoon.bboard.api.services;

import com.stonymoon.bboard.bean.SingerBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface SingerService {
    @GET("/singer/profile/{id}")
    Observable<SingerBean> getSinger(@Path("id") int id);

}
