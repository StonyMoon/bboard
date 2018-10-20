package com.stonymoon.bboard.singer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.util.ActivityUtil;


public class SingerActivity extends AppCompatActivity {
    public static final String SINGER_ID = "id";
    private SingerPresenter mPresenter;

    public static void startActivity(Context context, int id) {
        Intent intent = new Intent(context, SingerActivity.class);
        intent.putExtra(SINGER_ID, id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singer);
        SingerFragment singerFragment = (SingerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fl_rank_content);
        if (singerFragment == null) {
            singerFragment = SingerFragment.getInstance();
        }
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), singerFragment, R.id.fl_singer_content);
        mPresenter = new SingerPresenter(singerFragment, getIntent().getIntExtra(SINGER_ID, 1));
        singerFragment.setPresenter(mPresenter);
    }
}
