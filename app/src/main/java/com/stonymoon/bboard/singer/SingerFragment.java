package com.stonymoon.bboard.singer;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
import butterknife.OnClick;
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

    @BindView(R.id.recycler_singer_songs)
    RecyclerView recyclerSongs;

    private Unbinder mUnbinder;
    private SingerContract.Presenter mPresenter;
    private Context mContext;
    private SingerSongAdapter adapter = new SingerSongAdapter(new ArrayList<SingerBean.ResourceBean.SongsBean>());
    private SingerBean bean;

    public SingerFragment() {

    }

    public static SingerFragment getInstance() {
        return new SingerFragment();
    }

    @OnClick(R.id.tv_singer_info)
    void click() {
        showDialog();

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
        this.bean = bean;
        SingerBean.ResourceBean singer = bean.getResource();
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

    private void showDialog() {
        LayoutInflater factory = LayoutInflater.from(mContext);//提示框
        final View view = factory.inflate(R.layout.editbox_layout, null);//这里必须是final的
        final EditText edit = (EditText) view.findViewById(R.id.editText);//获得输入框对象

        new AlertDialog.Builder(mContext)
                .setTitle("修改歌手信息")//提示框标题
                .setView(view)
                .setPositiveButton("修改",//提示框的两个按钮
                        new android.content.DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {

                                MyApplication.putSinger(bean.getResource().getId(), edit.getText().toString());
                                tvInfo.setText(edit.getText().toString());
                            }
                        }).setNegativeButton("取消", null).create().show();

    }

}
