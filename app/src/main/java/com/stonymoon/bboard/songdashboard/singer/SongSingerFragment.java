package com.stonymoon.bboard.songdashboard.singer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.adapter.SingerItemAdapter;
import com.stonymoon.bboard.base.BaseFragment;
import com.stonymoon.bboard.bean.SongBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Stony on 2018/10/19.
 */

public class SongSingerFragment extends BaseFragment implements SongSingerContract.View {
    @BindView(R.id.recycler_song_dashboard_singer)
    RecyclerView mRecycler;
    private SongSingerContract.Presenter mPresenter;
    private List<SongBean.ResourceBean.SingersBean> mSingerList = new ArrayList<>();
    private SingerItemAdapter adapter = new SingerItemAdapter(mSingerList);

    public static SongSingerFragment getInstance() {
        return new SongSingerFragment();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_song_singer, container, false);
        mUnbinder = ButterKnife.bind(this, root);
        mRecycler.setAdapter(adapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        mPresenter.start();
        return root;
    }

    @Override
    public void setPresenter(SongSingerContract.Presenter presenter) {
        this.mPresenter = presenter;
    }


    @Override
    public void showError() {

    }

    @Override
    public void showProgressBar(boolean show) {

    }

    @Override
    public void showSinger(List<SongBean.ResourceBean.SingersBean> singersBeans) {
        mSingerList.addAll(singersBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setTitle(String title) {
        getActivity().setTitle(title);
    }
}
