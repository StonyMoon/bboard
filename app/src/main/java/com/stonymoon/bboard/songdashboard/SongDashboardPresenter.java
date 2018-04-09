package com.stonymoon.bboard.songdashboard;


import com.stonymoon.bboard.api.BaseDataManager;
import com.stonymoon.bboard.api.services.RankService;
import com.stonymoon.bboard.bean.SongBean;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SongDashboardPresenter implements SongDashboardContract.Presenter {
    private SongDashboardContract.View mView;
    private String mSongId;

    SongDashboardPresenter(SongDashboardContract.View view, String songId) {
        mView = view;
        mSongId = songId;
    }
    @Override
    public void start() {


    }

    @Override
    public void showRank() {
        RankService rankService = BaseDataManager.getHttpManager().create(RankService.class);
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
