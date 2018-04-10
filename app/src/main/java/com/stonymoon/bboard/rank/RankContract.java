package com.stonymoon.bboard.rank;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.BaseView;
import com.stonymoon.bboard.base.LoadingBaseView;
import com.stonymoon.bboard.bean.RankBean;

import java.util.List;


public interface RankContract {
    interface View extends LoadingBaseView<Presenter> {
        void showList(List<RankBean.ResourceBean> list);

    }

    interface Presenter extends BasePresenter {


    }


}
