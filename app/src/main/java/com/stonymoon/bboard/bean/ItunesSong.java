package com.stonymoon.bboard.bean;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class ItunesSong {
    /**
     * now_color : p2
     * position : 1
     * now_point : 1
     * discounted : 0
     * title : Drake - God's Plan
     */

    @SerializedName("now_color")
    private String nowColor;
    private int position;
    @SerializedName("now_point")
    private double nowPoint;
    private int discounted;
    private String title;

    @Generated(hash = 410920252)
    public ItunesSong(String nowColor, int position, double nowPoint,
                      int discounted, String title) {
        this.nowColor = nowColor;
        this.position = position;
        this.nowPoint = nowPoint;
        this.discounted = discounted;
        this.title = title;
    }

    @Generated(hash = 79394692)
    public ItunesSong() {
    }

    public String getNowColor() {
        return nowColor;
    }

    public void setNowColor(String nowColor) {
        this.nowColor = nowColor;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getNowPoint() {
        return nowPoint;
    }

    public void setNowPoint(double nowPoint) {
        this.nowPoint = nowPoint;
    }

    public int getDiscounted() {
        return discounted;
    }

    public void setDiscounted(int discounted) {
        this.discounted = discounted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
