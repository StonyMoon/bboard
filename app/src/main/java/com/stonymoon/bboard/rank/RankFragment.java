package com.stonymoon.bboard.rank;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.adapter.RankAdapter;
import com.stonymoon.bboard.bean.RankBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class RankFragment extends Fragment implements RankConstract.View {
    @BindView(R.id.pb_rank)
    ProgressBar mProgressBar;
    @BindView(R.id.recycler_rank)
    RecyclerView mRecyclerView;
    private RankConstract.Presenter mPresenter;
    private RankAdapter mAdapter;

    public RankFragment() {

    }

    //因为Fragment
    public static RankFragment getInstance() {
        return new RankFragment();
    }

    @Override
    public void setPresenter(RankConstract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showProgressBar(boolean show) {
        mProgressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_rank, container, false);
        mAdapter = new RankAdapter(new ArrayList<RankBean>());
        mRecyclerView.setAdapter(mAdapter);
        return root;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showList(List<RankBean> list) {

    }
}
