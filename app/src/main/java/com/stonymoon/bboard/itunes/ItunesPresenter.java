package com.stonymoon.bboard.itunes;


import com.stonymoon.bboard.api.BaseDataManager;
import com.stonymoon.bboard.api.services.ItunesService;
import com.stonymoon.bboard.bean.ItunesBean;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ItunesPresenter implements ItunesContract.Presenter {
    private final ItunesContract.View mItunesView;
    private List<ItunesBean.Song> mList = new ArrayList<>();

    @Inject
    public ItunesPresenter(ItunesContract.View itunesActivity) {
        mItunesView = itunesActivity;
        mItunesView.setPresenter(this);

    }

    public void loadItunes() {
        mItunesView.showLoading();
        ItunesService service = BaseDataManager.getHttpManager().create(ItunesService.class);
        service.getManagerData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ItunesBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mItunesView.showLoadFail();
                    }

                    @Override
                    public void onNext(ItunesBean itunesBean) {
                        mList.addAll(itunesBean.getSongs());
                        mItunesView.showItunesList(mList);
                        mItunesView.showLoadingSuccess();
                    }
                });


    }

    @Override
    public void start() {
        mList.clear();
        loadItunes();

    }


}
