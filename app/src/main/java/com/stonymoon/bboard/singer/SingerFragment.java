package com.stonymoon.bboard.singer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.stonymoon.bboard.R;
import com.stonymoon.bboard.adapter.SearchAdapter;
import com.stonymoon.bboard.adapter.SingerSongAdapter;
import com.stonymoon.bboard.base.ToolbarBaseFragment;
import com.stonymoon.bboard.bean.SearchBean;
import com.stonymoon.bboard.bean.SingerBean;
import com.stonymoon.bboard.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Retrofit;


public class SingerFragment extends Fragment implements SingerContract.View {
    @BindView(R.id.pb_singer)
    ProgressBar pbSinger;
    @BindView(R.id.tv_singer_area)
    TextView tvArea;
    @BindView(R.id.tv_singer_born)
    TextView tvBorn;
    @BindView(R.id.tv_singer_info)
    TextView tvInfo;
    @BindView(R.id.tv_singer_name)
    TextView tvName;
    @BindView(R.id.tv_singer_type)
    TextView tvType;
    @BindView(R.id.iv_singer_avatar)
    ImageView ivAvatar;
    @BindView(R.id.iv_singer_bg)
    ImageView ivBackground;

    @BindView(R.id.recycler_singer_songs)
    RecyclerView recyclerSongs;
    @BindView(R.id.collapsing_toolbar_singer)
    CollapsingToolbarLayout toolbar;

    private Unbinder mUnbinder;
    private SingerContract.Presenter mPresenter;
    private Context mContext;
    private SingerSongAdapter adapter = new SingerSongAdapter(new ArrayList<SingerBean.ResourceBean.SongsBean>());

    public SingerFragment() {

    }

    public static SingerFragment getInstance() {
        return new SingerFragment();
    }

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public void setPresenter(SingerContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showError() {
        ToastUtil.show(mContext, getString(R.string.error_message));
    }

    @Override
    public void showProgressBar(boolean show) {
        pbSinger.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showInfo(SingerBean bean) {
        SingerBean.ResourceBean singer = bean.getResource();
        tvArea.setText(singer.getArea());
        tvBorn.setText(singer.getBorn());
        tvInfo.setText(singer.getInfo());
        tvName.setText(singer.getName());
        tvType.setText(singer.getType());
        Glide.with(mContext)
                .load(singer.getImage())
                .into(ivAvatar);
        Glide.with(mContext)
                .load(singer.getImage())
                .into(ivBackground);
        adapter.setData(bean.getResource().getSongs());


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_singer, container, false);
        mUnbinder = ButterKnife.bind(this, root);
        recyclerSongs.setAdapter(adapter);
        recyclerSongs.setLayoutManager(new LinearLayoutManager(mContext));
        mPresenter.start();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }


}
