package com.stonymoon.bboard.api.services;


import com.stonymoon.bboard.bean.SearchBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface SearchService {
    //todo 填充api
    @GET("http://120.24.238.200:4567/search/song/{text}")
    Observable<SearchBean> search(@Path("text") String text);


}
