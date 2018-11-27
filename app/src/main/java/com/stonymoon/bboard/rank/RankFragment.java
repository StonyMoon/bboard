package com.stonymoon.bboard.rank;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.adapter.RankAdapter;
import com.stonymoon.bboard.base.ToolbarBaseFragment;
import com.stonymoon.bboard.bean.RankBean;
import com.stonymoon.bboard.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RankFragment extends ToolbarBaseFragment implements RankContract.View {
    @BindView(R.id.pb_rank)
    ProgressBar mProgressBar;
    @BindView(R.id.recycler_rank)
    RecyclerView mRecyclerView;

    private RankContract.Presenter mPresenter;
    private RankAdapter mAdapter;

    public RankFragment() {

    }

    //因为Fragment不推荐使用带有参数的构造方法，使用工厂模式灵活提供Fragment
    public static RankFragment getInstance() {
        return new RankFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = getContext();
    }

    @Override
    public void setPresenter(RankContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showProgressBar(boolean show) {
        mProgressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_rank, container, false);
        mUnbinder = ButterKnife.bind(this, root);
        mAdapter = new RankAdapter(new ArrayList<RankBean.DataBean>());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mPresenter.start();

        return root;
    }

    @Override
    public void showList(List<RankBean.DataBean> list) {
        mAdapter.setData(list);

    }

    @Override
    public void onResume() {
        super.onResume();
        setToolbarTitle("Billboard榜单");
    }

    @Override
    public void showError() {
        ToastUtil.show(mContext, getString(R.string.error_message));
    }
}
