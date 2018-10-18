package com.stonymoon.bboard.itunes;


import android.app.Application;

import com.stonymoon.bboard.api.BaseDataManager;
import com.stonymoon.bboard.api.services.ItunesService;
import com.stonymoon.bboard.app.MyApplication;
import com.stonymoon.bboard.bean.ItunesBean;
import com.stonymoon.bboard.bean.ItunesSong;
import com.stonymoon.bboard.dao.DaoSession;
import com.stonymoon.bboard.dao.ItunesSongDao;


import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ItunesPresenter implements ItunesContract.Presenter {
    private final ItunesContract.View mItunesView;
    private List<ItunesSong> mList = new ArrayList<>();
    private List<ItunesSong> mCollections = new ArrayList<>();

    @Inject
    public ItunesPresenter(ItunesContract.View itunesActivity) {
        mItunesView = itunesActivity;
        mItunesView.setPresenter(this);

    }

    public void loadItunes() {

        mItunesView.showProgressBar(true);
        ItunesService service = BaseDataManager
                .getHttpManager()
                .create(ItunesService.class);
        service.getManagerData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ItunesBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mItunesView.showProgressBar(false);
                        mItunesView.showError();
                    }

                    @Override
                    public void onNext(ItunesBean itunesBean) {
                        mList.clear();
                        mList.addAll(itunesBean.getSongs());
                        mItunesView.showItunesList(mList);
                        mItunesView.showProgressBar(false);
                    }
                });


    }

    @Override
    public void start() {
        mList.clear();
        loadItunes();

    }

    public void loadCollections() {
        mCollections.clear();
        DaoSession session = MyApplication.getInstances().getDaoSession();
        QueryBuilder<ItunesSong> builder = session.getItunesSongDao().queryBuilder();
        mCollections.addAll(builder.build().list());
        mItunesView.showItunesList(mCollections);
    }

    public void replaceWithItunes() {
        mItunesView.showItunesList(mList);
    }

    public void collectSong(ItunesSong song) {
        DaoSession session = MyApplication.getInstances().getDaoSession();
        session.getItunesSongDao().insert(song);
    }



}
