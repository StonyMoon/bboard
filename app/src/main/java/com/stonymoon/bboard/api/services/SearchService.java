package com.stonymoon.bboard.api.services;


import com.stonymoon.bboard.bean.SearchBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018/4/7.
 */

public interface SearchService {
    //todo 填充api
    @GET("http://120.24.238.200:5000/<text>")
    Observable<SearchBean> search(String text);


}
