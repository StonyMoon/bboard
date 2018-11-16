package com.stonymoon.bboard.itunes;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.BaseView;
import com.stonymoon.bboard.base.LoadingBaseView;
import com.stonymoon.bboard.bean.ItunesBean;
import com.stonymoon.bboard.bean.ItunesSong;

import java.util.List;

import dagger.Provides;


public interface ItunesContract {
    interface View extends LoadingBaseView<ItunesPresenter> {


        void showItunesList(List<ItunesSong> list);

        boolean isActive();

    }

    interface Presenter extends BasePresenter {
        void loadItunes();

        void replaceWithItunes();

        void collectSong(ItunesSong song);

        void loadCollections();
    }



}
