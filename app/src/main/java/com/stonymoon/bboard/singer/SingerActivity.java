package com.stonymoon.bboard.singer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.util.ActivityUtil;

import java.util.concurrent.RecursiveAction;

public class SingerActivity extends AppCompatActivity {
    private SingerPresenter mPresenter;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, SingerActivity.class));
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

        mPresenter = new SingerPresenter(singerFragment);
        singerFragment.setPresenter(mPresenter);
    }
}
