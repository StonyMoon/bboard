package com.stonymoon.bboard.bean;


public class RankBean {
    private String name;
    private String author;
    private int id;
    private int rank;
    private int week; //在榜周数
    private int peak;
    private int lastWeek;//上周名次

    public RankBean(String name, String author, int id, int rank, int week, int peak, int lastWeek) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.rank = rank;
        this.week = week;
        this.peak = peak;
        this.lastWeek = lastWeek;
    }

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
