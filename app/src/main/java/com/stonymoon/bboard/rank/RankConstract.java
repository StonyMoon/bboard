package com.stonymoon.bboard.rank;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.BaseView;
import com.stonymoon.bboard.bean.RankBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/12.
 */

public interface RankConstract {
    interface View extends BaseView<Presenter> {
        void showProgressBar(boolean show);

        void showList(List<RankBean> list);


    }

    interface Presenter extends BasePresenter {

    }


}
