package com.stonymoon.bboard.today;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.adapter.SingerBornAdapter;
import com.stonymoon.bboard.base.ToolbarBaseFragment;
import com.stonymoon.bboard.bean.SingerBornBean;
import com.stonymoon.bboard.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TodayFragment extends ToolbarBaseFragment implements TodayContract.View {

    @BindView(R.id.pb_today)
    ProgressBar mProgressBar;
    @BindView(R.id.recycler_today_singer)
    RecyclerView mRecyclerView;

    private SingerBornAdapter mAdapter;
    private TodayContract.Presenter mPresenter;

    public TodayFragment() {

    }

    public static TodayFragment getInstance() {
        return new TodayFragment();
    }


    @Override
    public void setPresenter(TodayContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showSinger(List<SingerBornBean.ResourceBean> singersBeans) {
        mAdapter.setData(singersBeans);
    }

    @Override
    public void showError() {
        ToastUtil.show(mContext, getString(R.string.error_message));
    }

    @Override
    public void showProgressBar(boolean show) {
        mProgressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_today, container, false);
        mUnbinder = ButterKnife.bind(this, root);
        mAdapter = new SingerBornAdapter(new ArrayList<SingerBornBean.ResourceBean>());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mPresenter.start();
        setToolbarTitle(getString(R.string.singer_born));
        return root;
    }


}
