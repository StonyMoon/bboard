package com.stonymoon.bboard.itunes;

import dagger.Module;
import dagger.Provides;


@Module
public class ItunesModel {
    private ItunesActivity activity;

    public ItunesModel(ItunesActivity activity) {
        this.activity = activity;
    }

    @Provides
    ItunesPresenter providePresenter() {
        return new ItunesPresenter(activity);

    }


}
