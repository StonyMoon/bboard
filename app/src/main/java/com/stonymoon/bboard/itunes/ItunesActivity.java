package com.stonymoon.bboard.itunes;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.adapter.ItunesAdapter;
import com.stonymoon.bboard.bean.ItunesBean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItunesActivity extends AppCompatActivity implements ItunesContract.View {

    @BindView(R.id.recycler_itunes)
    RecyclerView recyclerItunes;
    @BindView(R.id.pb_itunes)
    ProgressBar pbItunes;

    @Inject
    ItunesPresenter mPresenter;
    private ItunesAdapter mListAdapter;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ItunesActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itunes);
        ButterKnife.bind(this);
        mListAdapter = new ItunesAdapter(new ArrayList<ItunesBean.Song>(0));
        recyclerItunes.setLayoutManager(new LinearLayoutManager(this));
        recyclerItunes.setAdapter(mListAdapter);
        DaggerItunesComponent.builder()
                .itunesModel(new ItunesModel(this))
                .build()
                .inject(this);
        mPresenter.start();
    }

    @Override
    public void setTitle(String title) {
        this.setTitle(title);
    }

    @Override
    public void showItunesList(final List<ItunesBean.Song> list) {
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
    public void showLoadFail() {
        pbItunes.setVisibility(View.GONE);
        Toast.makeText(ItunesActivity.this, "加载失败", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showLoading() {
        pbItunes.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoadingSuccess() {
        pbItunes.setVisibility(View.GONE);
    }
}
