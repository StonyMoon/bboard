package com.stonymoon.bboard.search;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.adapter.SearchAdapter;
import com.stonymoon.bboard.bean.SearchBean;
import com.stonymoon.bboard.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class SearchFragment extends Fragment implements SearchContract.View {

    @BindView(R.id.pb_search)
    ProgressBar mProgressBar;
    @BindView(R.id.recycler_search)
    RecyclerView mRecyclerView;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.btn_search)
    Button btnSearch;


    private Unbinder mUnbinder;
    private Context mContext;
    private SearchAdapter mAdapter;
    private SearchContract.Presenter mPresenter;

    public SearchFragment() {

    }

    public static SearchFragment getInstance() {
        return new SearchFragment();
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = getContext();
    }

    @Override
    public void showList(List<SearchBean.ResourceBean> list) {
        mAdapter.setData(list);
    }

    @Override
    public void showError() {
        ToastUtil.show(mContext, getString(R.string.error_message));
    }

    @Override
    public void showProgressBar(boolean show) {
        mProgressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showNoResult() {
        ToastUtil.show(mContext, getString(R.string.no_result));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_search, container, false);
        mUnbinder = ButterKnife.bind(this, root);
        mAdapter = new SearchAdapter(new ArrayList<SearchBean.ResourceBean>());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.search(etSearch.getText().toString());
            }
        });


        return root;
    }


}
