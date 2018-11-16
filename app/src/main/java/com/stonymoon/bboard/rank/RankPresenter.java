package com.stonymoon.bboard.rank;

import com.stonymoon.bboard.api.BaseDataManager;
import com.stonymoon.bboard.api.services.BillboardService;
import com.stonymoon.bboard.bean.RankBean;


import java.util.Collections;
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
        BillboardService service = BaseDataManager.getHttpManager().create(BillboardService.class);
        service.getBillBoard("2018")
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
                        List<RankBean.ResourceBean> list = response.getResource();
                        Collections.sort(list);
                        mRankView.showList(list);
                        mRankView.showProgressBar(false);

                    }
                });


    }
}
