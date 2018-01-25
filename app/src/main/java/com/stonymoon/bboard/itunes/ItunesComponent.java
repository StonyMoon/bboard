package com.stonymoon.bboard.itunes;

import dagger.Component;


@Component(modules = ItunesModel.class)
public interface ItunesComponent {
    void inject(ItunesActivity itunesActivity);
    //ItunesPresenter providePresenter(ItunesActivity activity);

}
