package com.stonymoon.bboard.bean;

import java.util.List;

public class SongBean {

    /**
     * data : {"label":"UK Singles Top 75","chartid":"uk_singles_top_75","data":[[1517180400000,100,1],[1517785200000,100,1],[1518390000000,100,1],[1518994800000,100,1],[1519599600000,100,1],[1520204400000,100,1],[1520809200000,100,1],[1521414000000,100,1],[1522015200000,100,1]]}
     * feedback : {"text":"<i>UK Singles Top 75<\/i> is added to the graph below.","url":"","image":""}
     * status : {"status_code":200,"success":true}
     * analytics : {"send_event":true,"event_category":"performance-graph","event_action":"automatic_first","event_label":"added"}
     */

    private DataBean data;
    private FeedbackBean feedback;
    private StatusBean status;
    private AnalyticsBean analytics;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public FeedbackBean getFeedback() {
        return feedback;
    }

    public void setFeedback(FeedbackBean feedback) {
        this.feedback = feedback;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public AnalyticsBean getAnalytics() {
        return analytics;
    }

    public void setAnalytics(AnalyticsBean analytics) {
        this.analytics = analytics;
    }

    public static class DataBean {
        /**
         * label : UK Singles Top 75
         * chartid : uk_singles_top_75
         * data : [[1517180400000,100,1],[1517785200000,100,1],[1518390000000,100,1],[1518994800000,100,1],[1519599600000,100,1],[1520204400000,100,1],[1520809200000,100,1],[1521414000000,100,1],[1522015200000,100,1]]
         */

        private String label;
        private String chartid;
        private List<List<Long>> data;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getChartid() {
            return chartid;
        }

        public void setChartid(String chartid) {
            this.chartid = chartid;
        }

        public List<List<Long>> getData() {
            return data;
        }

        public void setData(List<List<Long>> data) {
            this.data = data;
        }
    }

    public static class FeedbackBean {
    }

    public static class StatusBean {
    }

    public static class AnalyticsBean {
    }
}
