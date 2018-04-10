package com.stonymoon.bboard.singer;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.LoadingBaseView;
import com.stonymoon.bboard.bean.SingerBean;

public interface SingerContract {
    interface View extends LoadingBaseView<Presenter> {
        void showInfo(SingerBean bean);

    }

    interface Presenter extends BasePresenter {


    }


}
