package com.stonymoon.bboard.bean;


public class SingerBean {


    /**
     * resource : {"name":"2pac","info":"Tupac Amaru Shakur (June 16, 1971\u2013September 13, 1996), also known by his stage names, Makaveli and 2Pac, was an American hip-hop artist, poet and actor. He is listed in the Guinness Book of World Records as the best-selling rap/hip-hop artist ever, having sold over 75 million albums worldwide, including 44.5 million sales in the United States alone. He has had 17 top ten singles in the United States. Read more about 2Pac on Last.fm .","area":"United States","image":"https://draw.acharts.net/artist/2pac-54661e84acf7a-l.jpeg","id":6,"type":"Male","born":"1971-6-16"}
     */

    private ResourceBean resource;

    public ResourceBean getResource() {
        return resource;
    }

    public void setResource(ResourceBean resource) {
        this.resource = resource;
    }

    public static class ResourceBean {
        /**
         * name : 2pac
         * info : Tupac Amaru Shakur (June 16, 1971–September 13, 1996), also known by his stage names, Makaveli and 2Pac, was an American hip-hop artist, poet and actor. He is listed in the Guinness Book of World Records as the best-selling rap/hip-hop artist ever, having sold over 75 million albums worldwide, including 44.5 million sales in the United States alone. He has had 17 top ten singles in the United States. Read more about 2Pac on Last.fm .
         * area : United States
         * image : https://draw.acharts.net/artist/2pac-54661e84acf7a-l.jpeg
         * id : 6
         * type : Male
         * born : 1971-6-16
         */

        private String name;
        private String info;
        private String area;
        private String image;
        private int id;
        private String type;
        private String born;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
    }
}
