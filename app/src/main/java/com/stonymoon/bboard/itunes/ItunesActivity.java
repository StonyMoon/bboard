package com.stonymoon.bboard.itunes;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.adapter.ItunesAdapter;
import com.stonymoon.bboard.bean.ItunesSong;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ItunesActivity extends AppCompatActivity implements ItunesContract.View {

    @BindView(R.id.recycler_itunes)
    RecyclerView recyclerItunes;
    @BindView(R.id.pb_itunes)
    ProgressBar pbItunes;
    @BindView(R.id.base_toolbar)
    Toolbar tbItunes;

    @Inject
    ItunesPresenter mPresenter;
    private ItunesAdapter mListAdapter;
    private boolean isItunes = true;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ItunesActivity.class);
        context.startActivity(intent);
    }

    @OnClick(R.id.iv_itunes_collection)
    void clickCollection() {
        if (isItunes) {
            mPresenter.loadCollections();
        } else {
            mPresenter.loadItunes();
        }
        isItunes = !isItunes;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itunes);
        ButterKnife.bind(this);
        Resources res = getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());

        mListAdapter = new ItunesAdapter(new ArrayList<ItunesSong>(0));
        recyclerItunes.setLayoutManager(new LinearLayoutManager(this));
        recyclerItunes.setAdapter(mListAdapter);

        DaggerItunesComponent.builder()
                .itunesModel(new ItunesModel(this))
                .build()
                .inject(this);
        initToolbar();
        mPresenter.start();
    }

    private void initToolbar() {
        setSupportActionBar(tbItunes);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Itunes");
        }
        tbItunes.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void showItunesList(final List<ItunesSong> list) {
        mListAdapter.setData(list);

    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void setPresenter(ItunesPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError() {
        Toast.makeText(ItunesActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(boolean show) {
        pbItunes.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}