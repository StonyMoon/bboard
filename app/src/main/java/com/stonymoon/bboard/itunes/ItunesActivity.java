package com.stonymoon.bboard.itunes;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.adapter.ItunesAdapter;
import com.stonymoon.bboard.bean.ItunesBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItunesActivity extends AppCompatActivity implements ItunesContract.View {

    @BindView(R.id.recycler_itunes)
    RecyclerView recyclerItunes;
    private ItunesContract.Presenter mPresenter;
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
        mPresenter = new ItunesPresenter(this);
        mListAdapter = new ItunesAdapter(new ArrayList<ItunesBean.Song>(0));
        recyclerItunes.setLayoutManager(new LinearLayoutManager(this));
        recyclerItunes.setAdapter(mListAdapter);
        mPresenter.start();
    }

    @Override
    public void setTitle(String title) {
        this.setTitle(title);
    }

    @Override
    public void showItunesList(final List<ItunesBean.Song> list) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mListAdapter.setData(list);
            }
        });

    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void setPresenter(ItunesContract.Presenter presenter) {
        mPresenter = presenter;
    }


}
