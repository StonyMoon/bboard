package com.stonymoon.bboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.stonymoon.bboard.itunes.ItunesActivity;
import com.stonymoon.bboard.rank.RankActivity;
import com.stonymoon.bboard.songdashboard.SongDashboardActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @OnClick({R.id.btn_main_itunes, R.id.btn_main_rank, R.id.btn_main_song_dashboard})
    void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main_itunes:
                ItunesActivity.startActivity(this);
                break;
            case R.id.btn_main_rank:
                RankActivity.startActivity(this);
                break;
            case R.id.btn_main_song_dashboard:
                SongDashboardActivity.startActivity(this);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
