package com.stonymoon.bboard.today;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.LoadingBaseView;
import com.stonymoon.bboard.bean.SingerBornBean;

import java.util.List;

public interface TodayContract {
    interface View extends LoadingBaseView<Presenter> {
        void showSinger(List<SingerBornBean.DataBean> singersBeans);

        void showError();
    }

    interface Presenter extends BasePresenter {

    }

}
