package com.stonymoon.bboard.singer;


import com.stonymoon.bboard.api.BaseDataManager;
import com.stonymoon.bboard.api.services.BillboardService;
import com.stonymoon.bboard.api.services.SingerService;
import com.stonymoon.bboard.bean.SingerBean;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SingerPresenter implements SingerContract.Presenter {
    private SingerContract.View mView;

    public SingerPresenter(SingerContract.View mView) {
        this.mView = mView;
    }

    public void start() {
        mView.showProgressBar(true);
        BaseDataManager.getHttpManager()
                .create(BillboardService.class)
                .getSinger(6)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<SingerBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                        mView.showProgressBar(false);
                    }

                    @Override
                    public void onNext(SingerBean singerBean) {
                        mView.showInfo(singerBean);
                        mView.showProgressBar(false);
                    }
                });

    }
}
