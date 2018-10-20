package com.stonymoon.bboard.maindashboard.today;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.base.BaseFragment;

import butterknife.ButterKnife;

public class TodaySingerFragment extends BaseFragment {
    public static TodaySingerFragment getInstance() {
        return new TodaySingerFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_singer, container, false);
        mUnbinder = ButterKnife.bind(this, root);
        return root;
    }


}
