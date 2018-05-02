package com.stonymoon.bboard.bean;

import java.util.List;

public class SingerBornBean {

    private List<ResourceBean> resource;

    public List<ResourceBean> getResource() {
        return resource;
    }

    public void setResource(List<ResourceBean> resource) {
        this.resource = resource;
    }

    public static class ResourceBean {
        /**
         * born : 1975-11-20
         * info : Bentley's musical style is considered to be more traditional than many of his contemporaries and often contains traditional themes of lost or forbidden love, drinking and cheating. "Lot of leavin' left to do", one of his biggest singles, is also reminiscent of Waylon Jennings' style of Outlaw country with Western Swing influences.  Early life
         * Dierks Bentley was born in Phoenix, Arizona. Then he moved to Lawrenceville, New Jersey, where he attended the Lawrenceville School, graduating in 1993.[1] Read more about Dierks Bentley on Last.fm .
         * image : https://draw.acharts.net/artist/dierks_bentley-54661df0f0f4a-l.jpeg
         * type : Male
         * id : 498
         * name : Dierks Bentley
         * area : United States
         */

        private String born;
        private String info;
        private String image;
        private String type;
        private int id;
        private String name;
        private String area;

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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

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

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }
}
