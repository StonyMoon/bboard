package com.stonymoon.bboard.search;


import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.BaseView;
import com.stonymoon.bboard.bean.SearchBean;

import java.util.List;

public interface SearchContract {
    interface View extends BaseView<Presenter> {
        void showList(List<SearchBean.ResourceBean> list);

        void showError();

        void showProgressBar(boolean show);

        void showNoResult();


    }

    interface Presenter extends BasePresenter {
        void search(String songName);

    }


}
