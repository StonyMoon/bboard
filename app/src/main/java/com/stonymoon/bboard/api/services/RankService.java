package com.stonymoon.bboard.api.services;


import com.stonymoon.bboard.bean.RankBean;
import com.stonymoon.bboard.bean.SongBean;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;


public interface RankService {
    @GET("/us_singles_top_100")
    Observable<List> getUS();

    @GET("/uk_singles_top_75")
    Observable<List> getUK();

    @GET("/world_singles_top_40")
    Observable<List> getWorld();


    //callback/GraphData/
    @FormUrlEncoded
    @POST("/callback/GraphData")
    Observable<SongBean> getRank(@Field("titleid") String titleId, @Field("chart") String chart, @Field("initiator") String initiator);

}
