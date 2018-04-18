package com.stonymoon.bboard.maindashboard;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.adapter.MyFragmentPagerAdapter;
import com.stonymoon.bboard.rank.RankFragment;
import com.stonymoon.bboard.rank.RankPresenter;
import com.stonymoon.bboard.search.SearchFragment;
import com.stonymoon.bboard.search.SearchPresenter;
import com.stonymoon.bboard.singer.SingerFragment;
import com.stonymoon.bboard.singer.SingerPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainDashboardActivity extends AppCompatActivity {
    @BindView(R.id.tab_main)
    TabLayout mTabLayout;
    @BindView(R.id.pager_main)
    ViewPager mViewPager;
    private SingerFragment mSingerFragment;
    private RankFragment mRankFragment;
    private SearchFragment mSearchFragment;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainDashboardActivity.class);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        ButterKnife.bind(this);
        initFragment();
    }

    private void initFragment() {
        mSearchFragment = SearchFragment.getInstance();
        mRankFragment = RankFragment.getInstance();
        mSingerFragment = SingerFragment.getInstance();
        mSearchFragment.setPresenter(new SearchPresenter(mSearchFragment));
        mRankFragment.setPresenter(new RankPresenter(mRankFragment));
        mSingerFragment.setPresenter(new SingerPresenter(mSingerFragment));
        List<String> titles = new ArrayList<>();
        titles.add("a");
        titles.add("b");
        titles.add("c");
        for (String title : titles) {
            mTabLayout.addTab(mTabLayout.newTab().setText(title));
        }
        mTabLayout.setupWithViewPager(mViewPager);
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(mSearchFragment);
        fragmentList.add(mRankFragment);
        fragmentList.add(mSingerFragment);


        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setCurrentItem(0);

    }


}
