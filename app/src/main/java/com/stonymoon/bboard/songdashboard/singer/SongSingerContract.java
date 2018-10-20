package com.stonymoon.bboard.songdashboard.singer;

import com.stonymoon.bboard.base.BasePresenter;
import com.stonymoon.bboard.base.LoadingBaseView;
import com.stonymoon.bboard.bean.SongBean;

import java.util.List;

/**
 * Created by Stony on 2018/10/20.
 */

public interface SongSingerContract {
    interface View extends LoadingBaseView<SongSingerContract.Presenter> {
        void showSinger(List<SongBean.ResourceBean.SingersBean> singersBeans);

    }

    interface Presenter extends BasePresenter {

    }
}
