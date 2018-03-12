package com.stonymoon.bboard.api.services;

import com.stonymoon.bboard.bean.ItunesBean;
import com.stonymoon.bboard.bean.RankBean;

import retrofit2.http.POST;
import rx.Observable;


public interface RankService {
    @POST("/")
    Observable<RankBean> getManagerData();

}
