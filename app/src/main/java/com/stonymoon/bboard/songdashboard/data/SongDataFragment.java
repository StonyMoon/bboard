package com.stonymoon.bboard.songdashboard.data;


import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.base.BaseFragment;
import com.stonymoon.bboard.util.ToastUtil;

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
    private String mRank = "";

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
        ToastUtil.show(mContext, getResources().getString(R.string.data_not_found));
    }

    @Override
    public void showProgressBar(boolean show) {

    }

    @SuppressLint("SetTextI18n")
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
        builder.deleteCharAt(builder.length() - 1);
        mRank = builder.toString();
        tvRank.setText(getString(R.string.song_rank) + mRank);
        tvFirstWeeks.setText(getString(R.string.song_first) + firstWeeks);
        tvTenthWeeks.setText(getString(R.string.song_tenth) + tenthWeeks);
        tvFiftiethWeeks.setText(getString(R.string.song_fiftieth) + fiftiethWeeks);
        tvTotalWeeks.setText(getString(R.string.song_total_weeks) + list.size());
    }


    @OnClick(R.id.tv_song_data_copy)
    public void onViewClicked() {
        ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText(mRank);
        ToastUtil.show(mContext, getString(R.string.copy_toast));
    }
}
