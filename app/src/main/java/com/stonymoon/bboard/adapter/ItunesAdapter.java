package com.stonymoon.bboard.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.bean.ItunesBean;
import com.stonymoon.bboard.bean.ItunesSong;

import java.util.List;


public class ItunesAdapter extends RecyclerView.Adapter<ItunesAdapter.ItunesViewHolder> {

    private List<ItunesSong> mSongs;
    private Context mContext;

    public ItunesAdapter(List<ItunesSong> songs) {
        mSongs = songs;
    }


    public void setData(List<ItunesSong> songs) {
        mSongs = songs;
        notifyDataSetChanged();
    }


    public ItunesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();

        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_itunes, parent, false);
        final ItunesViewHolder holder = new ItunesViewHolder(view);
        return holder;

    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    public void onBindViewHolder(ItunesViewHolder holder, int position) {
        ItunesSong song = mSongs.get(position);
        holder.tvTitle.setText(song.getTitle());
        String point = String.format("%.2f", song.getNowPoint());
        holder.tvPoint.setText(point);
        holder.tvRank.setText(song.getPosition() + "");


        if (song.getDiscounted() == 1) {
            holder.tvDiscounted.setText("$");
        } else {
            holder.tvDiscounted.setText(" ");

        }
        switch (song.getNowColor()) {
            case "n2":
                holder.llItunes.setBackgroundColor(0xFFFFBBBB);
                break;
            case "n1":
                holder.llItunes.setBackgroundColor(0xFFFFDDDD);
                break;
            case "p1":
                holder.llItunes.setBackgroundColor(0xFFDDFFDD);
                break;
            case "p2":
                holder.llItunes.setBackgroundColor(0xFFBBFFBB);
                break;
            default:
                holder.llItunes.setBackgroundColor(0xFFFFFFFF);
                break;

        }


    }

    static class ItunesViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvRank;
        TextView tvPoint;
        TextView tvDiscounted;
        LinearLayout llItunes;

        public ItunesViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tv_itunes_title);
            tvRank = (TextView) view.findViewById(R.id.tv_itunes_rank);
            tvPoint = (TextView) view.findViewById(R.id.tv_itunes_point);
            tvDiscounted = (TextView) view.findViewById(R.id.tv_itunes_discounted);
            llItunes = (LinearLayout) view.findViewById(R.id.ll_itunes_item);
        }

    }


}
