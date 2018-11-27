package com.stonymoon.bboard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.bean.SearchBean;
import com.stonymoon.bboard.songdashboard.SongDashboardActivity;

import java.util.List;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private List<SearchBean.DataBean> mSongs;
    private Context mContext;

    public SearchAdapter(List<SearchBean.DataBean> songs) {
        mSongs = songs;
    }


    public void setData(List<SearchBean.DataBean> songs) {
        mSongs = songs;
        notifyDataSetChanged();
    }


    public SearchAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();

        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        final SearchAdapter.SearchViewHolder holder = new SearchAdapter.SearchViewHolder(view);


        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                String id = mSongs.get(position).getId() + "";
                SongDashboardActivity.startActivity(mContext, id);
            }
        });


        return holder;

    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    public void onBindViewHolder(SearchAdapter.SearchViewHolder holder, int position) {
        SearchBean.DataBean song = mSongs.get(position);
        holder.tvTitle.setText(song.getTitle());
        holder.tvSinger.setText(song.getSingers().get(0).getName());


    }

    static class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvSinger;
        LinearLayout llItem;

        public SearchViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tv_search_item_title);
            tvSinger = (TextView) view.findViewById(R.id.tv_search_item_singer);
            llItem = (LinearLayout) view.findViewById(R.id.ll_search_item);
        }

    }


}
