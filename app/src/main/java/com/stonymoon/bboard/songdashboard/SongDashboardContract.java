package com.stonymoon.bboard.songdashboard;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.LoadingBaseView;
import com.stonymoon.bboard.bean.SongBean;


import java.util.List;

public interface SongDashboardContract {
    interface View extends LoadingBaseView<Presenter> {
        void showChart(List<Integer> list);
        void setTitle(String title);
        void setTextView(SongBean songBean);
    }

    interface Presenter extends BasePresenter {
        void showRank();


    }

}
