package com.stonymoon.bboard.adapter;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.app.MyApplication;
import com.stonymoon.bboard.bean.ItunesBean;
import com.stonymoon.bboard.bean.ItunesSong;
import com.stonymoon.bboard.dao.DaoSession;
import com.stonymoon.bboard.dao.ItunesSongDao;
import com.stonymoon.bboard.util.ToastUtil;

import org.greenrobot.greendao.query.Query;

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

    public void onBindViewHolder(final ItunesViewHolder holder, int position) {
        ItunesSong song = mSongs.get(position);
        holder.tvTitle.setText(song.getTitle());
        String point = String.format("%.4f", song.getNowPoint());
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
        holder.llItunes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItunesSong itunesSong = mSongs.get(holder.getAdapterPosition());
                showDialog(itunesSong);
            }
        });


    }

    private void collectSong(ItunesSong song) {
        DaoSession session = MyApplication.getInstances().getDaoSession();
        session.getItunesSongDao().insert(song);
    }

    private void showDialog(final ItunesSong song) {
        final ItunesSongDao dao = MyApplication.getInstances().getDaoSession().getItunesSongDao();
        final Query query = dao.queryBuilder().where(
                ItunesSongDao.Properties.Title.eq(song.getTitle())).build();
        final List<ItunesSong> result = query.list();

        if (result.size() == 0) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
            dialog.setTitle("收藏歌曲");
            dialog.setMessage("是否收藏" + song.getTitle() + "(收藏后可点击右上角菜单查看歌曲)");
            dialog.setCancelable(false);
            dialog.setPositiveButton("添加", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dao.insert(song);
                    ToastUtil.show(mContext, "歌曲已收藏");
                }
            });
            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();


        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
            dialog.setTitle("删除歌曲");
            dialog.setMessage("歌曲已存在，是否从收藏中移除?");
            dialog.setCancelable(false);
            dialog.setPositiveButton("移除", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dao.queryBuilder().where(
                            ItunesSongDao.Properties.Title.eq(song.getTitle())).buildDelete().executeDeleteWithoutDetachingEntities();

                    ToastUtil.show(mContext, "歌曲已删除");
                }
            });
            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();

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
