package com.stonymoon.bboard.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import butterknife.Unbinder;

/**
 * Created by Stony on 2018/10/20.
 */

public class BaseFragment extends Fragment {
    protected Context mContext;
    protected Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
