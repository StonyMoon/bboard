package com.stonymoon.bboard.api.services;


import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;


public interface RankService {
    @GET("/us_singles_top_100")
    Observable<Response<ResponseBody>> getUS();

    @GET("/uk_singles_top_75")
    Observable<Response<ResponseBody>> getUK();

    @GET("/world_singles_top_40")
    Observable<Response<ResponseBody>> getWorld();
//callback/GraphData/
}
