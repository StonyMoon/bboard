package com.stonymoon.bboard.bean;

import java.util.List;

public class SongBean {


    /**
     * success : true
     * message : OK
     * data : {"singers":[{"id":148,"image":"https://draw.acharts.net/artist/avril_lavigne-54661eb150e10-l.png","name":"Avril Lavigne"}],"billboards":[{"rank":71,"date":"2003-04-26T00:00:00.000+0000"},{"rank":68,"date":"2003-05-03T00:00:00.000+0000"},{"rank":64,"date":"2003-05-10T00:00:00.000+0000"},{"rank":64,"date":"2003-05-17T00:00:00.000+0000"},{"rank":70,"date":"2003-05-24T00:00:00.000+0000"},{"rank":93,"date":"2003-05-31T00:00:00.000+0000"}],"id":150,"title":"Losing Grip"}
     */

    private boolean success;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * singers : [{"id":148,"image":"https://draw.acharts.net/artist/avril_lavigne-54661eb150e10-l.png","name":"Avril Lavigne"}]
         * billboards : [{"rank":71,"date":"2003-04-26T00:00:00.000+0000"},{"rank":68,"date":"2003-05-03T00:00:00.000+0000"},{"rank":64,"date":"2003-05-10T00:00:00.000+0000"},{"rank":64,"date":"2003-05-17T00:00:00.000+0000"},{"rank":70,"date":"2003-05-24T00:00:00.000+0000"},{"rank":93,"date":"2003-05-31T00:00:00.000+0000"}]
         * id : 150
         * title : Losing Grip
         */

        private int id;
        private String title;
        private List<SingersBean> singers;
        private List<BillboardsBean> billboards;

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

        public List<SingersBean> getSingers() {
            return singers;
        }

        public void setSingers(List<SingersBean> singers) {
            this.singers = singers;
        }

        public List<BillboardsBean> getBillboards() {
            return billboards;
        }

        public void setBillboards(List<BillboardsBean> billboards) {
            this.billboards = billboards;
        }

        public static class SingersBean {
            /**
             * id : 148
             * image : https://draw.acharts.net/artist/avril_lavigne-54661eb150e10-l.png
             * name : Avril Lavigne
             */

            private int id;
            private String image;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class BillboardsBean {
            /**
             * rank : 71
             * date : 2003-04-26T00:00:00.000+0000
             */

            private int rank;
            private String date;

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
        }
    }
}
