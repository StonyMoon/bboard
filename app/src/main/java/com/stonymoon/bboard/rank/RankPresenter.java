package com.stonymoon.bboard.rank;

import com.google.gson.Gson;
import com.stonymoon.bboard.api.AchartsManager;
import com.stonymoon.bboard.api.services.RankService;
import com.stonymoon.bboard.bean.RankBean;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class RankPresenter implements RankConstract.Presenter {
    private RankConstract.View mRankView;


    public RankPresenter(RankConstract.View view) {
        this.mRankView = view;
    }


    @Override
    public void start() {
        mRankView.showProgressBar(true);
        RankService service = AchartsManager.getHttpManager().create(RankService.class);
        service.getManagerData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<RankBean>() {
                    @Override
                    public void onCompleted() {
                        mRankView.showProgressBar(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mRankView.showProgressBar(false);
                    }

                    @Override
                    public void onNext(RankBean rankBean) {


                    }
                });


    }
}
