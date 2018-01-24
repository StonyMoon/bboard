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

import java.util.List;


public class ItunesAdapter extends RecyclerView.Adapter<ItunesAdapter.ItunesViewHolder> {

    private List<ItunesBean.Song> mSongs;
    private Context mContext;

    public ItunesAdapter(List<ItunesBean.Song> songs) {
        mSongs = songs;
    }


    public void setData(List<ItunesBean.Song> songs) {
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
        ItunesBean.Song song = mSongs.get(position);
        holder.tvTitle.setText(song.title);
        String po = (song.nowPoint) + "";
        holder.tvPoint.setText(po);
        holder.tvPoint.setText(song.position + "");
        if (song.discounted == 1) {
            holder.tvDiscounted.setText("$");
        } else {
            holder.tvDiscounted.setText(" ");

        }
        switch (song.nowColor) {
            case "n2":
                holder.itunesLayout.setBackgroundColor(0xFFFFBBBB);
                break;
            case "n1":
                holder.itunesLayout.setBackgroundColor(0xFFFFDDDD);
                break;
            case "p1":
                holder.itunesLayout.setBackgroundColor(0xFFDDFFDD);
                break;
            case "p2":
                holder.itunesLayout.setBackgroundColor(0xFFBBFFBB);
                break;
            default:
                holder.itunesLayout.setBackgroundColor(0xFFFFFFFF);
                break;

        }


    }

    static class ItunesViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvRank;
        TextView tvPoint;
        TextView tvDiscounted;
        LinearLayout itunesLayout;

        public ItunesViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.itunes_title_text);
            tvRank = (TextView) view.findViewById(R.id.itunes_rank_text);
            tvPoint = (TextView) view.findViewById(R.id.itunes_point_text);
            tvDiscounted = (TextView) view.findViewById(R.id.itunes_discounted_text);
            itunesLayout = (LinearLayout) view.findViewById(R.id.itunes_layout);
        }

    }


}
