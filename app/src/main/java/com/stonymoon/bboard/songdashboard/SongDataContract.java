package com.stonymoon.bboard.songdashboard;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.LoadingBaseView;
import com.stonymoon.bboard.bean.SongBean;

import java.util.List;

/**
 * Created by Stony on 2018/10/18.
 */

public interface SongDataContract {
    interface View extends LoadingBaseView<SongDataContract.Presenter> {
        void showChart(List<Integer> list);

        void showSinger(List<SongBean.ResourceBean.SingersBean> singersBeans);
    }

    interface Presenter extends BasePresenter {
        void initView();

    }


}
