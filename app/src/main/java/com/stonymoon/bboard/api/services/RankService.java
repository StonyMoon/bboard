package com.stonymoon.bboard.api.services;


import com.stonymoon.bboard.bean.RankBean;

import java.util.List;
import retrofit2.http.GET;
import rx.Observable;


public interface RankService {
    @GET("/us_singles_top_100")
    Observable<List> getUS();

    @GET("/uk_singles_top_75")
    Observable<List> getUK();

    @GET("/world_singles_top_40")
    Observable<List> getWorld();
//callback/GraphData/
}
