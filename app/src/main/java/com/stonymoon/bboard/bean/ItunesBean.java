package com.stonymoon.bboard.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class ItunesBean {
    @SerializedName("all_song")
    public List<Song> songs = new ArrayList<>();

    public class Song {
        public String title;
        public int position;
        @SerializedName("now_point")
        public  double nowPoint;
        @SerializedName("now_color")
        public String nowColor;
        public  int discounted;
    }
}
