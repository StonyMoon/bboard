package com.stonymoon.bboard.itunes;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.BaseView;
import com.stonymoon.bboard.bean.ItunesBean;

import java.util.List;



public interface ItunesContract {
    interface View extends BaseView<Presenter> {
        void setTitle(String title);

        void showItunesList(List<ItunesBean.Song> list);

        boolean isActive();
    }

    interface Presenter extends BasePresenter {
        void loadItunes();

    }



}
