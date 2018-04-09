package com.stonymoon.bboard.api.services;


import com.stonymoon.bboard.bean.SearchBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface SearchService {
    @GET("/search/song/{text}")
    Observable<SearchBean> search(@Path("text") String text);


}
