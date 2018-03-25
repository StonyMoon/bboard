package com.stonymoon.bboard.songdashboard;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.util.ToastUtil;

import java.util.List;

import butterknife.BindView;


public class SongDashboardFragment extends Fragment implements SongDashboardContract.View {
    @BindView(R.id.pb_song_dashboard)
    ProgressBar mProgressBar;

    private SongDashboardContract.Presenter mPresenter;
    private Context mContext;

    public SongDashboardFragment() {
    }

    public static SongDashboardFragment getInstance() {
        return new SongDashboardFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void setPresenter(SongDashboardContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showChart(List list) {

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
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }
}
