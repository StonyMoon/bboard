package com.stonymoon.bboard.songdashboard;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.adapter.MyFragmentPagerAdapter;
import com.stonymoon.bboard.songdashboard.chart.SongChartContract;
import com.stonymoon.bboard.songdashboard.chart.SongChartFragment;
import com.stonymoon.bboard.songdashboard.chart.SongChartPresenter;
import com.stonymoon.bboard.songdashboard.data.SongDataContract;
import com.stonymoon.bboard.songdashboard.data.SongDataFragment;
import com.stonymoon.bboard.songdashboard.data.SongDataPresenter;
import com.stonymoon.bboard.songdashboard.singer.SongSingerContract;
import com.stonymoon.bboard.songdashboard.singer.SongSingerFragment;
import com.stonymoon.bboard.songdashboard.singer.SongSingerPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongDashboardActivity extends AppCompatActivity {
    private static final String SONG_ID = "SONG_ID";
    @BindView(R.id.tab_song)
    TabLayout mTabLayout;
    @BindView(R.id.pager_song)
    ViewPager mViewPager;


    public static void startActivity(Context context, String songId) {
        Intent intent = new Intent(context, SongDashboardActivity.class);
        intent.putExtra(SONG_ID, songId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_dashboard);
        ButterKnife.bind(this);
        initFragment();

    }

    private void initFragment() {
        List<String> titles = new ArrayList<>();
        titles.add("排名走势");
        titles.add("歌曲数据");
        titles.add("歌手信息");
        for (String title : titles) {
            mTabLayout.addTab(mTabLayout.newTab().setText(title));
        }
        mTabLayout.setupWithViewPager(mViewPager);
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        SongChartFragment chartFragment = SongChartFragment.getInstance();
        SongDataFragment dataFragment = SongDataFragment.getInstance();
        SongSingerFragment singerFragment = SongSingerFragment.getInstance();
        String id = getIntent().getStringExtra(SONG_ID);
        SongChartContract.Presenter chartPresenter = new SongChartPresenter(chartFragment, id);
        SongSingerContract.Presenter singerPresenter = new SongSingerPresenter(singerFragment, id);
        SongDataContract.Presenter dataPresenter = new SongDataPresenter(dataFragment, id);
        chartFragment.setPresenter(chartPresenter);
        singerFragment.setPresenter(singerPresenter);
        dataFragment.setPresenter(dataPresenter);
        fragmentList.add(chartFragment);
        fragmentList.add(dataFragment);
        fragmentList.add(singerFragment);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setCurrentItem(0);

    }
}
