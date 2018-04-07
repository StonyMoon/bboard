package com.stonymoon.bboard.bean;

import java.util.List;

public class SearchBean {
    private List<ResourceBean> resource;

    public List<ResourceBean> getResource() {
        return resource;
    }

    public void setResource(List<ResourceBean> resource) {
        this.resource = resource;
    }

    public static class ResourceBean {
        /**
         * singers : [{"name":"Erykah Badu","id":593},{"name":"Common","id":408}]
         * title : Love Of My Life (an Ode To Hip Hop)
         * id : 40
         */

        private String title;
        private int id;
        private List<SingersBean> singers;

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

        public static class SingersBean {
            /**
             * name : Erykah Badu
             * id : 593
             */

            private String name;
            private int id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
