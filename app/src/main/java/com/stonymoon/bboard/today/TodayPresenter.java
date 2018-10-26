package com.stonymoon.bboard.today;


import com.stonymoon.bboard.api.BaseDataManager;
import com.stonymoon.bboard.api.services.BillboardService;
import com.stonymoon.bboard.bean.SingerBornBean;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TodayPresenter implements TodayContract.Presenter {
    private TodayContract.View mView;

    TodayPresenter(TodayContract.View mView) {
        this.mView = mView;
    }

    public void start() {
        mView.showProgressBar(true);
        BaseDataManager.getHttpManager()
                .create(BillboardService.class)
                .getSingerByBorn()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<SingerBornBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showProgressBar(false);
                        mView.showError();
                    }

                    @Override
                    public void onNext(SingerBornBean singerBornBean) {
                        mView.showProgressBar(false);
                        mView.showSinger(singerBornBean.getResource());
                    }
                });

    }
}
