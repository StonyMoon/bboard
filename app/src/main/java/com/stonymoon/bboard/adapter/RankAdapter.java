package com.stonymoon.bboard.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.bean.RankBean;
import com.stonymoon.bboard.songdashboard.SongDashboardActivity;

import java.util.List;


public class RankAdapter extends RecyclerView.Adapter<RankAdapter.ItunesViewHolder> {

    private List<RankBean> mRankList;
    private Context mContext;

    public RankAdapter(List<RankBean> s) {
        mRankList = s;
    }

    public void setData(List<RankBean> list) {
        this.mRankList = list;
        notifyDataSetChanged();
    }

    public ItunesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rank, parent, false);
        final ItunesViewHolder holder = new ItunesViewHolder(view);
        holder.RankLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                RankBean b = mRankList.get(position);
                SongDashboardActivity.startActivity(mContext, b.getId() + "");

            }
        });


        return holder;

    }

    @Override
    public int getItemCount() {
        return mRankList.size();
    }

    public void onBindViewHolder(ItunesViewHolder holder, int position) {
        RankBean RankBean = mRankList.get(position);
        holder.rankText.setText(RankBean.getRank() + "");
        holder.authorText.setText(RankBean.getAuthor());
        holder.titleText.setText(RankBean.getName());
        if (RankBean.getLastWeek() > RankBean.getRank()) {
            holder.rankImage.setImageResource(R.mipmap.up_arrow);
        } else if (RankBean.getLastWeek() == RankBean.getRank()) {
            holder.rankImage.setImageResource(R.mipmap.line);

        } else {
            holder.rankImage.setImageResource(R.mipmap.down_arrow);
        }
        if (RankBean.getLastWeek() == 101) {
            holder.lastWeekText.setText("new");
        } else {
            holder.lastWeekText.setText("" + Math.abs(RankBean.getLastWeek() - RankBean.getRank()));
        }

    }

    static class ItunesViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        TextView rankText;
        TextView lastWeekText;
        TextView authorText;
        ImageView rankImage;
        LinearLayout RankLayout;

        public ItunesViewHolder(View view) {
            super(view);
            titleText = (TextView) view.findViewById(R.id.tv_rank_title);
            rankText = (TextView) view.findViewById(R.id.tv_rank_rank);
            lastWeekText = (TextView) view.findViewById(R.id.tv_rank_lastweek);
            authorText = (TextView) view.findViewById(R.id.tv_rank_singer);
            rankImage = (ImageView) view.findViewById(R.id.iv_rank);
            RankLayout = (LinearLayout) view.findViewById(R.id.ll_rank_item);

        }

    }


}
