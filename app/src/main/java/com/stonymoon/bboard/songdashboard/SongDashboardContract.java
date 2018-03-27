package com.stonymoon.bboard.songdashboard;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.BaseView;
import com.stonymoon.bboard.bean.ItunesBean;
import com.stonymoon.bboard.bean.SongBean;

import java.util.List;

public interface SongDashboardContract {
    interface View extends BaseView<Presenter> {
        void showChart(List<List<Long>> list);

        void showError();

        void showProgressBar(boolean show);


    }

    interface Presenter extends BasePresenter {


    }

}
