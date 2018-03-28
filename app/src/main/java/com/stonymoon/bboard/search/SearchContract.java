package com.stonymoon.bboard.search;


import com.stonymoon.bboard.base.BasePresenter;

public interface SearchContract {
    interface View {
        void showList();

        void showError();

        void showProgressBar(boolean show);

        void showNoResult();

    }

    interface Presenter extends BasePresenter {
        void search(String songName);

    }


}
