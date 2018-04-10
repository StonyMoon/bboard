package com.stonymoon.bboard.rank;

import com.stonymoon.bboard.api.BaseDataManager;
import com.stonymoon.bboard.api.services.RankService;
import com.stonymoon.bboard.bean.RankBean;

import java.util.Date;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class RankPresenter implements RankContract.Presenter {
    private RankContract.View mRankView;


    RankPresenter(RankContract.View view) {
        this.mRankView = view;
    }


    @Override
    public void start() {
        mRankView.showProgressBar(true);
        RankService service = BaseDataManager.getHttpManager().create(RankService.class);
        service.getBillBoard("2018-3-3")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<RankBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        mRankView.showProgressBar(false);
                        mRankView.showError();
                    }

                    @Override
                    public void onNext(RankBean response) {
                        mRankView.showList(response.getResource());
                        mRankView.showProgressBar(false);

                    }
                });


    }
}
