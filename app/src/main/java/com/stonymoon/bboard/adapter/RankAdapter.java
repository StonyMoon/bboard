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

import static com.stonymoon.bboard.bean.RankBean.ResourceBean;

import java.util.List;


public class RankAdapter extends RecyclerView.Adapter<RankAdapter.ItunesViewHolder> {

    private List<ResourceBean> mRankList;
    private Context mContext;

    public RankAdapter(List<ResourceBean> s) {
        mRankList = s;
    }

    public void setData(List<ResourceBean> list) {
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
                ResourceBean b = mRankList.get(position);
                SongDashboardActivity.startActivity(mContext, b.getSong().getId() + "");

            }
        });


        return holder;

    }

    @Override
    public int getItemCount() {
        return mRankList.size();
    }

    public void onBindViewHolder(ItunesViewHolder holder, int position) {
        ResourceBean bean = mRankList.get(position);
        holder.rankText.setText(bean.getRank() + "");
        List<String> singers = bean.getSong().getSingers();
        //check null,if null then set empty string
        holder.authorText.setText((singers == null || singers.get(0) == null) ? "" : singers.get(0));
        holder.titleText.setText(bean.getSong().getTitle());
        if (bean.getPrevious() > bean.getRank()) {
            holder.rankImage.setImageResource(R.mipmap.up_arrow);
        } else if (bean.getPrevious() == bean.getRank()) {
            holder.rankImage.setImageResource(R.mipmap.line);

        } else {
            holder.rankImage.setImageResource(R.mipmap.down_arrow);
        }
        if (bean.getPrevious() == 0) {
            holder.lastWeekText.setText("new");
        } else {
            holder.lastWeekText.setText("" + Math.abs(bean.getPrevious() - bean.getRank()));
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
