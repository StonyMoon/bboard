package com.stonymoon.bboard.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.util.ActivityUtil;

import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {
    private SearchContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        SearchFragment searchFragment = (SearchFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fl_rank_content);
        if (searchFragment == null) {
            searchFragment = SearchFragment.getInstance();
        }
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), searchFragment, R.id.fl_search_content);
        mPresenter = new SearchPresenter(searchFragment);
        searchFragment.setPresenter(mPresenter);
    }
}
