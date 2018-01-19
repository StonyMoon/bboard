package com.stonymoon.bboard.itunes;

import com.stonymoon.bboard.bean.ItunesBean;

import java.util.List;

/**
 * Created by stony on 18-1-19.
 */

public interface ItunesContract {
    interface View {
        void setTitle(String title);
        void showItunes(List<ItunesBean> list);

    }
    interface Presenter {




    }



}
