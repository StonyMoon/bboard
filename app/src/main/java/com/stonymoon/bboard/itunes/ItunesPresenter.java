package com.stonymoon.bboard.itunes;


import com.google.gson.Gson;
import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.bean.ItunesBean;
import com.stonymoon.bboard.util.HttpUtil;
import com.stonymoon.bboard.util.UrlUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class ItunesPresenter implements ItunesContract.Presenter {
    private final ItunesContract.View mItunesView;
    private List<ItunesBean.Song> mList = new ArrayList<>();

    @Inject
    public ItunesPresenter(ItunesContract.View itunesActivity) {
        mItunesView = itunesActivity;
        mItunesView.setPresenter(this);

    }

    public void loadItunes() {
        String url = UrlUtil.getItunesList();
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mItunesView.showLoadFail();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                ItunesBean bean = gson.fromJson(response.body().string(), ItunesBean.class);
                mList.addAll(bean.getSongs());
                mItunesView.showItunesList(mList);

            }
        });


    }

    @Override
    public void start() {
        mList.clear();
        loadItunes();

    }


}
