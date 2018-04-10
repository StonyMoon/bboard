package com.stonymoon.bboard.base;


public interface LoadingBaseView<T> extends BaseView<T> {
    void showError();

    void showProgressBar(boolean show);

}
