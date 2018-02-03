package com.stonymoon.bboard.itunes;


import com.google.gson.Gson;
import com.stonymoon.bboard.api.BaseDataManager;
import com.stonymoon.bboard.api.services.ItunesService;
import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.bean.ItunesBean;
import com.stonymoon.bboard.util.HttpUtil;
import com.stonymoon.bboard.util.UrlUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ItunesPresenter implements ItunesContract.Presenter {
    private final ItunesContract.View mItunesView;
    private List<ItunesBean.Song> mList = new ArrayList<>();

    @Inject
    public ItunesPresenter(ItunesContract.View itunesActivity) {
        mItunesView = itunesActivity;
        mItunesView.setPresenter(this);

    }

    public void loadItunes() {
        Call<ItunesBean> call = BaseDataManager.getHttpManager().create(ItunesService.class).getManagerData();
        call.enqueue(new Callback<ItunesBean>() {
            @Override
            public void onResponse(Call<ItunesBean> call, Response<ItunesBean> response) {
                if (response.body() == null) {
                    return;
                }
                mList.addAll(response.body().getSongs());
                mItunesView.showItunesList(mList);
            }

            @Override
            public void onFailure(Call<ItunesBean> call, Throwable t) {
                //todo
            }
        });

    }

    @Override
    public void start() {
        mList.clear();
        loadItunes();

    }


}
