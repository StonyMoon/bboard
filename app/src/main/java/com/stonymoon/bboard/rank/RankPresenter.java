package com.stonymoon.bboard.rank;

import com.stonymoon.bboard.api.AchartsManager;
import com.stonymoon.bboard.api.services.RankService;
import com.stonymoon.bboard.bean.RankBean;
import com.stonymoon.bboard.util.ResponseUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class RankPresenter implements RankContract.Presenter {
    private RankContract.View mRankView;


    public RankPresenter(RankContract.View view) {
        this.mRankView = view;
    }


    @Override
    public void start() {
        mRankView.showProgressBar(true);
        RankService service = AchartsManager.getHttpManager().create(RankService.class);
        service.getUK()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ResponseBody>>() {
                    @Override
                    public void onCompleted() {
                        mRankView.showProgressBar(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mRankView.showProgressBar(false);
                        mRankView.showError();
                    }

                    @Override
                    public void onNext(Response<ResponseBody> response) {
                        String body = null;
                        try {
                            body = response.body().string();
                        } catch (IOException e) {
                            mRankView.showProgressBar(false);
                            mRankView.showError();
                        }
                        List<RankBean> rankBeans = ResponseUtil.handleRankResponse(body);
                        mRankView.showList(rankBeans);
                    }
                });


    }
}
