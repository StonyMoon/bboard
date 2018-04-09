package com.stonymoon.bboard.bean;

import java.util.List;

public class SongBean {


    /**
     * resource : {"title":"Love Story","singers":[{"info":"Taylor Alison Swift (born December 13, 1989 in Wyomissing, Pennsylvania) is an American country pop singer-songwriter and actress.  In 2006, she released her debut single \"Tim McGraw\", then her self-titled debut album, which was subsequently certified multi-platinum by the Recording Industry Association of America. In November 2008, Swift released her second album, Fearless. Fearless and Taylor Swift finished 2008 at number-three and number-six respectively, with sales of 2.1 and 1.5 million. Fearless has topped the Billboard 200 in 11 non-consecutive weeks; no album has spent more time at No. Read more about Taylor Swift on Last.fm .","type":"Female","born":"1989-12-13","area":"United States","image":"https://draw.acharts.net/artist/taylor_swift-54661b9acd1f9-l.png","id":1710,"name":"Taylor Swift"}],"ranks":[49,46,46,42,40,41,38,33,29,26,26,28,34,24,21,18,18,16,14,14,15,13,13,12,9,8,7,7,5,5,5,5,4,5,7,11,12,12,14,18,14,16,15,14,14,13,9,5,16],"id":37722}
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
         * title : Love Story
         * singers : [{"info":"Taylor Alison Swift (born December 13, 1989 in Wyomissing, Pennsylvania) is an American country pop singer-songwriter and actress.  In 2006, she released her debut single \"Tim McGraw\", then her self-titled debut album, which was subsequently certified multi-platinum by the Recording Industry Association of America. In November 2008, Swift released her second album, Fearless. Fearless and Taylor Swift finished 2008 at number-three and number-six respectively, with sales of 2.1 and 1.5 million. Fearless has topped the Billboard 200 in 11 non-consecutive weeks; no album has spent more time at No. Read more about Taylor Swift on Last.fm .","type":"Female","born":"1989-12-13","area":"United States","image":"https://draw.acharts.net/artist/taylor_swift-54661b9acd1f9-l.png","id":1710,"name":"Taylor Swift"}]
         * ranks : [49,46,46,42,40,41,38,33,29,26,26,28,34,24,21,18,18,16,14,14,15,13,13,12,9,8,7,7,5,5,5,5,4,5,7,11,12,12,14,18,14,16,15,14,14,13,9,5,16]
         * id : 37722
         */

        private String title;
        private int id;
        private List<SingersBean> singers;
        private List<Integer> ranks;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<SingersBean> getSingers() {
            return singers;
        }

        public void setSingers(List<SingersBean> singers) {
            this.singers = singers;
        }

        public List<Integer> getRanks() {
            return ranks;
        }

        public void setRanks(List<Integer> ranks) {
            this.ranks = ranks;
        }

        public static class SingersBean {
            /**
             * info : Taylor Alison Swift (born December 13, 1989 in Wyomissing, Pennsylvania) is an American country pop singer-songwriter and actress.  In 2006, she released her debut single "Tim McGraw", then her self-titled debut album, which was subsequently certified multi-platinum by the Recording Industry Association of America. In November 2008, Swift released her second album, Fearless. Fearless and Taylor Swift finished 2008 at number-three and number-six respectively, with sales of 2.1 and 1.5 million. Fearless has topped the Billboard 200 in 11 non-consecutive weeks; no album has spent more time at No. Read more about Taylor Swift on Last.fm .
             * type : Female
             * born : 1989-12-13
             * area : United States
             * image : https://draw.acharts.net/artist/taylor_swift-54661b9acd1f9-l.png
             * id : 1710
             * name : Taylor Swift
             */

            private String info;
            private String type;
            private String born;
            private String area;
            private String image;
            private int id;
            private String name;

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
