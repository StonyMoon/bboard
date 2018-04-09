package com.stonymoon.bboard.songdashboard;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.BaseView;


import java.util.List;

public interface SongDashboardContract {
    interface View extends BaseView<Presenter> {
        void showChart(List<Integer> list);

        void showError();

        void showProgressBar(boolean show);


    }

    interface Presenter extends BasePresenter {
        void showRank();

    }

}
