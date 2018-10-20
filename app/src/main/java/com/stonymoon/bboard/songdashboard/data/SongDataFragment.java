package com.stonymoon.bboard.songdashboard.data;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Stony on 2018/10/18.
 */

public class SongDataFragment extends BaseFragment implements SongDataContract.View {

    @BindView(R.id.tv_song_data_rank)
    TextView tvRank;
    @BindView(R.id.tv_song_data_total_weeks)
    TextView tvTotalWeeks;
    @BindView(R.id.tv_song_data_first_weeks)
    TextView tvFirstWeeks;
    @BindView(R.id.tv_song_data_tenth_weeks)
    TextView tvTenthWeeks;
    @BindView(R.id.tv_song_data_fiftieth_weeks)
    TextView tvFiftiethWeeks;
    private SongDataContract.Presenter mPresenter;

    public static SongDataFragment getInstance() {
        return new SongDataFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_song_data, container, false);
        mUnbinder = ButterKnife.bind(this, root);
        mPresenter.start();
        return root;
    }

    @Override
    public void setPresenter(SongDataContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showError() {

    }

    @Override
    public void showProgressBar(boolean show) {

    }

    @Override
    public void initData(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        int firstWeeks = 0;
        int tenthWeeks = 0;
        int fiftiethWeeks = 0;
        for (int i : list) {
            builder.append(i);
            builder.append("-");
            if (i == 1) firstWeeks++;
            if (i <= 10) tenthWeeks++;
            if (i <= 50) fiftiethWeeks++;
        }
        tvRank.setText(builder.toString());
        tvFirstWeeks.setText(firstWeeks + "");
        tvTenthWeeks.setText(tenthWeeks + "");
        tvFiftiethWeeks.setText(fiftiethWeeks + "");
        tvTotalWeeks.setText(list.size() + "");
    }


    @OnClick(R.id.tv_song_data_rank)
    public void onViewClicked() {
    }
}
