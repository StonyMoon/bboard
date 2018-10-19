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
import com.stonymoon.bboard.util.ActivityUtil;

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
    private SongDashboardContract.Presenter mPresenter;

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
        SongDashboardFragment songDashboardFragment = SongDashboardFragment.getInstance();
        mPresenter = new SongDashboardPresenter(songDashboardFragment, getIntent().getStringExtra(SONG_ID));
        songDashboardFragment.setPresenter(mPresenter);
        fragmentList.add(songDashboardFragment);
        fragmentList.add(SongDataFragment.getInstance());
        fragmentList.add(SongSingerFragment.getInstance());

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setCurrentItem(0);

    }
}
