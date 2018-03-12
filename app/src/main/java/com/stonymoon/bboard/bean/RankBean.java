package com.stonymoon.bboard.bean;

/**
 * Created by Administrator on 2018/3/12.
 */

public class RankBean {
    private String name;
    private String author;
    private int id;
    private int rank;
    private int week; //在榜周数
    private int peak;
    private int lastWeek;//上周名次

    public String getName() {
        return name;
    }

    public int getPeak() {
        return peak;
    }

    public int getLastWeek() {
        return lastWeek;
    }

    public int getWeek() {
        return week;
    }

    public int getRank() {
        return rank;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }


}
