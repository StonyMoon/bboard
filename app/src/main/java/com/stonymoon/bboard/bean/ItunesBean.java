package com.stonymoon.bboard.bean;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;
import java.util.List;


public class ItunesBean {

    @SerializedName("all_song")
    private List<ItunesSong> songs;

    public List<ItunesSong> getSongs() {
        return songs;
    }

    public void setSongs(List<ItunesSong> songs) {
        this.songs = songs;
    }




}
