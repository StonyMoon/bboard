package com.stonymoon.bboard;

import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.stonymoon.bboard.itunes.ItunesActivity;
import com.stonymoon.bboard.maindashboard.MainDashboardActivity;
import com.stonymoon.bboard.rank.RankActivity;
import com.stonymoon.bboard.search.SearchActivity;
import com.stonymoon.bboard.singer.SingerActivity;
import com.stonymoon.bboard.today.TodayActivity;
import com.stonymoon.bboard.version.VersionActivity;
import com.tencent.bugly.beta.Beta;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.drawer)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_main)
    NavigationView mNavigationView;
    @BindView(R.id.toolbar_main)
    Toolbar mToolbar;

    public boolean onOptionsItemSelected(MenuItem item) {
        //设置菜单键
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(Gravity.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @OnClick({R.id.iv_main_itunes, R.id.iv_main_rank, R.id.iv_main_search, R.id.iv_main_search_big, R.id.iv_main_today})
    void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.iv_main_itunes:
                ItunesActivity.startActivity(this);
                break;
            case R.id.iv_main_rank:
                RankActivity.startActivity(this);
                break;
            case R.id.iv_main_search:
                SearchActivity.startActivity(this);
                break;
            case R.id.iv_main_search_big:
                SearchActivity.startActivity(this);
                break;
            case R.id.iv_main_today:
                TodayActivity.startActivity(this);
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                VersionActivity.startActivity(MainActivity.this);
                return true;
            }
        });
        initToolbar();

        Beta.checkUpgrade(false, true);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        }
    }


}
