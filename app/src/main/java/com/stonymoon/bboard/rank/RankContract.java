package com.stonymoon.bboard.rank;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.BaseView;
import com.stonymoon.bboard.bean.RankBean;

import java.util.List;


public interface RankContract {
    interface View extends BaseView<Presenter> {
        void showProgressBar(boolean show);

        void showList(List<RankBean.ResourceBean> list);

        void showError();

    }

    interface Presenter extends BasePresenter {


    }


}
