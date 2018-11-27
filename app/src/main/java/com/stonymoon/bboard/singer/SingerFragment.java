package com.stonymoon.bboard.singer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.stonymoon.bboard.R;
import com.stonymoon.bboard.adapter.SingerSongAdapter;
import com.stonymoon.bboard.app.MyApplication;
import com.stonymoon.bboard.bean.SingerBean;
import com.stonymoon.bboard.util.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.picasso.transformations.BlurTransformation;


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
    CircleImageView ivAvatar;
    @BindView(R.id.iv_singer_bg)
    ImageView ivBackground;
    @BindView(R.id.toolbar_profile)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.recycler_singer_songs)
    RecyclerView recyclerSongs;

    private Unbinder mUnbinder;
    private SingerContract.Presenter mPresenter;
    private Context mContext;
    private SingerSongAdapter adapter = new SingerSongAdapter(new ArrayList<SingerBean.DataBean.SongsBean>());


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
        SingerBean.DataBean singer = bean.getData();
        tvArea.setText(singer.getArea());
        tvBorn.setText(singer.getBorn());
        if (MyApplication.getSinger(singer.getId()) == null) {
            tvInfo.setText(singer.getInfo());
        } else {
            tvInfo.setText(MyApplication.getSinger(singer.getId()));
        }
        tvName.setText(singer.getName());
        tvType.setText(singer.getType());
        Picasso.with(mContext).load(singer.getImage())
                .transform(new BlurTransformation(mContext, 25, 3)).into(ivBackground);
        Glide.with(mContext)
                .load(singer.getImage())
                .into(ivAvatar);

        adapter.setData(bean.getData().getSongs());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_singer, container, false);
        mUnbinder = ButterKnife.bind(this, root);
        recyclerSongs.setAdapter(adapter);
        recyclerSongs.setLayoutManager(new LinearLayoutManager(mContext));
        mPresenter.start();
        initToolbar();
        return root;
    }

    private void initToolbar() {
        if (toolbar != null && getActivity() instanceof AppCompatActivity) {
            AppCompatActivity activity = ((AppCompatActivity) getActivity());
            activity.setSupportActionBar(toolbar);
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().finish();
                    }
                });
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void setTitle(String title) {
        collapsingToolbarLayout.setTitle(title);
        toolbar.setTitle(title);
    }
}
