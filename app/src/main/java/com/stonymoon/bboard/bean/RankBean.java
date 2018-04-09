package com.stonymoon.bboard.bean;


import java.util.List;

public class RankBean {


    private List<ResourceBean> resource;

    public List<ResourceBean> getResource() {
        return resource;
    }

    public void setResource(List<ResourceBean> resource) {
        this.resource = resource;
    }

    public static class ResourceBean {
        /**
         * weeks : 5
         * song : {"id":111437,"title":"God's Plan","singers":["Drake"]}
         * previous : 1
         * peak : 1
         * rank : 1
         */

        private int weeks;
        private SongBean song;
        private int previous;
        private int peak;
        private int rank;

        public int getWeeks() {
            return weeks;
        }

        public void setWeeks(int weeks) {
            this.weeks = weeks;
        }

        public SongBean getSong() {
            return song;
        }

        public void setSong(SongBean song) {
            this.song = song;
        }

        public int getPrevious() {
            return previous;
        }

        public void setPrevious(int previous) {
            this.previous = previous;
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

        public static class SongBean {
            /**
             * id : 111437
             * title : God's Plan
             * singers : ["Drake"]
             */

            private int id;
            private String title;
            private List<String> singers;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<String> getSingers() {
                return singers;
            }

            public void setSingers(List<String> singers) {
                this.singers = singers;
            }
        }
    }
}
