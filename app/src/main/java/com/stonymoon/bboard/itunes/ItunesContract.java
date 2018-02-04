package com.stonymoon.bboard.itunes;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.BaseView;
import com.stonymoon.bboard.bean.ItunesBean;

import java.util.List;

import dagger.Provides;


public interface ItunesContract {
    interface View extends BaseView<ItunesPresenter> {
        void setTitle(String title);

        void showItunesList(List<ItunesBean.Song> list);

        void showLoadFail();

        void showLoading();

        void showLoadingSuccess();
        boolean isActive();


    }

    interface Presenter extends BasePresenter {
        void loadItunes();

    }



}
