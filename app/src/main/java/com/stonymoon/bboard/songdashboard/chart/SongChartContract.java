package com.stonymoon.bboard.songdashboard.chart;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.LoadingBaseView;

import java.util.List;

/**
 * Created by Stony on 2018/10/20.
 */

public interface SongChartContract {
    interface View extends LoadingBaseView<SongChartContract.Presenter> {
        void showChart(List<Integer> list);

    }

    interface Presenter extends BasePresenter {

    }
}
