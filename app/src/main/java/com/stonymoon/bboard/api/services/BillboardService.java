package com.stonymoon.bboard.api.services;

import com.stonymoon.bboard.bean.RankBean;
import com.stonymoon.bboard.bean.SearchBean;
import com.stonymoon.bboard.bean.SingerBean;
import com.stonymoon.bboard.bean.SingerBornBean;
import com.stonymoon.bboard.bean.SongBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface BillboardService {
    @GET("/v1/billboards")
    Observable<RankBean> getBillBoard();

    @GET("/v1/songs/{id}")
    Observable<SongBean> getRank(@Path("id") String id);

    @GET("/search/songs/{text}")
    Observable<SearchBean> searchSong(@Path("text") String text);

    @GET("/singers/{id}")
    Observable<SingerBean> getSinger(@Path("id") int id);


    @GET("/today/singers")
    Observable<SingerBornBean> getSingerByBorn();

    // 这个API不一定会被用到
    @GET("/search/singer/{text}")
    Observable<SingerBean> searchSinger(@Path("text") String text);


}