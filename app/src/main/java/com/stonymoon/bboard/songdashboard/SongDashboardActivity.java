package com.stonymoon.bboard.songdashboard;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.rank.RankActivity;
import com.stonymoon.bboard.util.ActivityUtil;

import butterknife.ButterKnife;

public class SongDashboardActivity extends AppCompatActivity {
    private SongDashboardContract.Presenter mPresenter;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SongDashboardActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_dashboard);
        ButterKnife.bind(this);
        SongDashboardFragment songDashboardFragment = (SongDashboardFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fl_song_dashboard_content);
        if (songDashboardFragment == null) {
            songDashboardFragment = SongDashboardFragment.getInstance();
        }
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), songDashboardFragment, R.id.fl_song_dashboard_content);
        mPresenter = new SongDashboardPresenter();
        songDashboardFragment.setPresenter(mPresenter);
    }
}
