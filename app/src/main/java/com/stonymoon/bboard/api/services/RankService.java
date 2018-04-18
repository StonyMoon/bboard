package com.stonymoon.bboard.api.services;


import com.stonymoon.bboard.bean.RankBean;
import com.stonymoon.bboard.bean.SongBean;



import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface RankService {
    @GET("/billboard/{date}")
    Observable<RankBean> getBillBoard(@Path("date") String date);


    @GET("/song/{id}")
    Observable<SongBean> getRank(@Path("id") String id);

}
