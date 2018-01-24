package com.stonymoon.bboard.itunes;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/24.
 */
@Component(modules = ItunesModel.class)
public interface ItunesComponent {
    void inject(ItunesActivity itunesActivity);
    //ItunesPresenter providePresenter(ItunesActivity activity);

}
