package com.stonymoon.bboard.bean;


import android.support.annotation.NonNull;

import java.util.List;

public class RankBean {


    private boolean success;
    private String message;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Comparable<DataBean> {

        private int id;
        private int previous;
        private int weeks;
        private int peak;
        private int rank;
        private String date;
        private int songId;
        private String title;
        private List<SingersBean> singers;

        @Override
        public int compareTo(@NonNull DataBean dataBean) {
            return this.rank - dataBean.rank;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPrevious() {
            return previous;
        }

        public void setPrevious(int previous) {
            this.previous = previous;
        }

        public int getWeeks() {
            return weeks;
        }

        public void setWeeks(int weeks) {
            this.weeks = weeks;
        }

        public int getPeak() {
            return peak;
        }

        public void setPeak(int peak) {
            this.peak = peak;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getSongId() {
            return songId;
        }

        public void setSongId(int songId) {
            this.songId = songId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<SingersBean> getSingers() {
            return singers;
        }

        public void setSingers(List<SingersBean> singers) {
            this.singers = singers;
        }

        public static class SingersBean {
            /**
             * id : 59
             * name : Alice Merton
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
