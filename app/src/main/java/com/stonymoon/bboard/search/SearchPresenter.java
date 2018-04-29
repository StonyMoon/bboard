package com.stonymoon.bboard.search;


import com.stonymoon.bboard.api.BaseDataManager;
import com.stonymoon.bboard.api.services.BillboardService;
import com.stonymoon.bboard.api.services.SearchService;
import com.stonymoon.bboard.bean.SearchBean;


import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchPresenter implements SearchContract.Presenter {

    private SearchContract.View mView;

    public SearchPresenter(SearchContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void search(String songName) {
        mView.showProgressBar(true);
        BillboardService service = BaseDataManager.getHttpManager().create(BillboardService.class);
        service.searchSong(songName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<SearchBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showProgressBar(false);
                        mView.showError();
                    }

                    @Override
                    public void onNext(SearchBean searchBean) {
                        mView.showProgressBar(false);
                        mView.showList(searchBean.getResource());
                    }
                });


    }
}
