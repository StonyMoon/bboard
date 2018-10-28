package com.stonymoon.bboard.today;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.util.ActivityUtil;

import butterknife.ButterKnife;

public class TodayActivity extends AppCompatActivity {
    private TodayPresenter mPresenter;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, TodayActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        ButterKnife.bind(this);
        TodayFragment todayFragment = (TodayFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fl_today_content);
        if (todayFragment == null) {
            todayFragment = TodayFragment.getInstance();
        }
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), todayFragment, R.id.fl_today_content);
        mPresenter = new TodayPresenter(todayFragment);
        todayFragment.setPresenter(mPresenter);

    }
}
