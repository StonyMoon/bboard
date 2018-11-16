package com.stonymoon.bboard.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.stonymoon.bboard.R;
import com.stonymoon.bboard.bean.SongBean;
import com.stonymoon.bboard.singer.SingerActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SingerItemAdapter extends RecyclerView.Adapter<SingerItemAdapter.SingerBornViewHolder> {
    private List<SongBean.ResourceBean.SingersBean> mSingers;
    private Context mContext;

    public SingerItemAdapter(List<SongBean.ResourceBean.SingersBean> singers) {
        mSingers = singers;
    }


    public void setData(List<SongBean.ResourceBean.SingersBean> songs) {
        mSingers = songs;
        notifyDataSetChanged();
    }


    public SingerItemAdapter.SingerBornViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();

        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_singer, parent, false);
        final SingerItemAdapter.SingerBornViewHolder holder = new SingerItemAdapter.SingerBornViewHolder(view);


        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                int id = mSingers.get(position).getId();
                SingerActivity.startActivity(mContext, id);
            }
        });

        return holder;

    }

    @Override
    public int getItemCount() {
        return mSingers.size();
    }

    public void onBindViewHolder(SingerItemAdapter.SingerBornViewHolder holder, int position) {
        SongBean.ResourceBean.SingersBean singer = mSingers.get(position);
        holder.tvName.setText(singer.getName());
        if (singer.getImage() != null) {
            Glide.with(mContext).load(singer.getImage()).into(holder.ivSinger);
        }

    }

    static class SingerBornViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        LinearLayout llItem;
        CircleImageView ivSinger;

        public SingerBornViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tv_singer_item_name);
            ivSinger = (CircleImageView) view.findViewById(R.id.circle_iv_singer_item);
            llItem = (LinearLayout) view.findViewById(R.id.ll_singer);

        }

    }


}
