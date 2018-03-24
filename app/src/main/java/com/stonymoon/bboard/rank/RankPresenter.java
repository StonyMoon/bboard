package com.stonymoon.bboard.rank;

import com.stonymoon.bboard.api.BaseDataManager;
import com.stonymoon.bboard.api.services.RankService;
import com.stonymoon.bboard.bean.RankBean;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class RankPresenter implements RankContract.Presenter {
    private RankContract.View mRankView;


    public RankPresenter(RankContract.View view) {
        this.mRankView = view;
    }


    @Override
    public void start() {
        mRankView.showProgressBar(true);
        RankService service = BaseDataManager.getHttpManager().create(RankService.class);
        service.getUK()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List>() {
                    @Override
                    public void onCompleted() {
                        mRankView.showProgressBar(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mRankView.showProgressBar(false);
                        mRankView.showError();
                    }

                    @Override
                    public void onNext(List response) {
                        mRankView.showList((List<RankBean>) response);
                    }
                });


    }
}
