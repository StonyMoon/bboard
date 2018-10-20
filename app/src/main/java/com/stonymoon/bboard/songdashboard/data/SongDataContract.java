package com.stonymoon.bboard.songdashboard.data;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.LoadingBaseView;

import java.util.List;

/**
 * Created by Stony on 2018/10/20.
 */

public interface SongDataContract {
    interface View extends LoadingBaseView<SongDataContract.Presenter> {
        void initData(List<Integer> list);

    }

    interface Presenter extends BasePresenter {

    }

}
