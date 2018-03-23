package com.stonymoon.bboard.rank;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.stonymoon.bboard.R;
import com.stonymoon.bboard.util.ActivityUtil;

import butterknife.ButterKnife;


public class RankActivity extends AppCompatActivity {
    private RankConstract.Presenter mPresenter;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RankActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        ButterKnife.bind(this);
        RankFragment rankFragment = (RankFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fl_rank_content);
        if (rankFragment == null) {
            rankFragment = RankFragment.getInstance();

        }


        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), rankFragment, R.id.fl_rank_content);
        // 因为activity与fragment生命周期同步所以在fragment调用onResume之前presenter已经被实例化了
        mPresenter = new RankPresenter(rankFragment);
        rankFragment.setPresenter(mPresenter);
    }


}
