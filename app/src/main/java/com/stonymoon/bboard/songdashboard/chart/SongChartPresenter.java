package com.stonymoon.bboard.songdashboard.chart;

import com.stonymoon.bboard.api.BaseDataManager;
import com.stonymoon.bboard.api.services.BillboardService;
import com.stonymoon.bboard.bean.SongBean;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Stony on 2018/10/20.
 */

public class SongChartPresenter implements SongChartContract.Presenter {
    private SongChartContract.View mView;
    private String mSongId;

    public SongChartPresenter(SongChartContract.View mView, String mSongId) {
        this.mView = mView;
        this.mSongId = mSongId;
    }

    public void start() {
        BillboardService rankService = BaseDataManager.getHttpManager().create(BillboardService.class);
        mView.showProgressBar(true);
        rankService.getRank(mSongId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<SongBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                        mView.showProgressBar(false);
                    }

                    @Override
                    public void onNext(SongBean songBean) {
                        mView.showProgressBar(false);
                        mView.showChart(songBean.getResource().getRanks());

                    }
                });

    }
}
