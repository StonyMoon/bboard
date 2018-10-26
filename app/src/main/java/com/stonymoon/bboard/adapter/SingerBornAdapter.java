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
import com.stonymoon.bboard.bean.SingerBornBean;
import com.stonymoon.bboard.singer.SingerActivity;
import com.stonymoon.bboard.songdashboard.SongDashboardActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SingerBornAdapter extends RecyclerView.Adapter<SingerBornAdapter.SingerBornViewHolder> {
    private List<SingerBornBean.ResourceBean> mSingers;
    private Context mContext;

    public SingerBornAdapter(List<SingerBornBean.ResourceBean> singers) {
        mSingers = singers;
    }


    public void setData(List<SingerBornBean.ResourceBean> songs) {
        mSingers = songs;
        notifyDataSetChanged();
    }


    public SingerBornAdapter.SingerBornViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();

        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_singer_born, parent, false);
        final SingerBornAdapter.SingerBornViewHolder holder = new SingerBornAdapter.SingerBornViewHolder(view);


        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                String id = mSingers.get(position).getId() + "";
                SingerActivity.startActivity(mContext, Integer.valueOf(id));
            }
        });

        return holder;

    }

    @Override
    public int getItemCount() {
        return mSingers.size();
    }

    public void onBindViewHolder(SingerBornAdapter.SingerBornViewHolder holder, int position) {
        SingerBornBean.ResourceBean singer = mSingers.get(position);
        holder.tvName.setText(singer.getName());
        Glide.with(mContext).load(singer.getImage()).into(holder.ivAvatar);

    }

    static class SingerBornViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        LinearLayout llItem;
        CircleImageView ivAvatar;

        SingerBornViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tv_singer_born_name);
            llItem = (LinearLayout) view.findViewById(R.id.ll_singer_born);
            ivAvatar = view.findViewById(R.id.iv_singer_born_avatar);
        }

    }


}
