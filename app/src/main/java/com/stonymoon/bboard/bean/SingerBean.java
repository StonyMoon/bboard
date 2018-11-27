package com.stonymoon.bboard.bean;


import java.util.List;

public class SingerBean {

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

        private int id;
        private String image;
        private String name;
        private String area;
        private String type;
        private String born;
        private String info;
        private List<SongsBean> songs;

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

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getBorn() {
            return born;
        }

        public void setBorn(String born) {
            this.born = born;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public List<SongsBean> getSongs() {
            return songs;
        }

        public void setSongs(List<SongsBean> songs) {
            this.songs = songs;
        }

        public static class SongsBean {
            /**
             * id : 79125
             * title : Thinking About You
             * singers : [{"id":150,"name":"Ayah Marar"}]
             */

            private int id;
            private String title;
            private List<SingersBean> singers;

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

            public static class SingersBean {
                /**
                 * id : 150
                 * name : Ayah Marar
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
}
