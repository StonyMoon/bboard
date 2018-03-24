package com.stonymoon.bboard.util;


import com.stonymoon.bboard.bean.RankBean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ResponseUtil {
    public static List<RankBean> handleRankResponse(String response) {
        List<RankBean> resultList = new ArrayList<>();
        Document doc = Jsoup.parse(response);
        Elements results = doc.select("[itemprop=itemListElement]");
        for (Element eachSong : results) {
            String temp;
            String author;
            int id;
            int rank;
            int week; //在榜周数
            int peak;
            int lastWeek;//上周名次
            String rankAndLast[] = eachSong.select(".cNum").select("span").text().split(" ");
            rank = Integer.parseInt(rankAndLast[0]);
            temp = rankAndLast[1].split("\\(")[1].split("\\)")[0];
            if (temp.equals("re-entry")) {
                lastWeek = 101;
            } else if (temp.equals("new")) {
                lastWeek = 101;
            } else {
                lastWeek = Integer.parseInt(temp);
            }
            temp = eachSong.select(".cShidden").text();
            String peakAndWeek[] = temp.split(" ");
            peak = Integer.parseInt(peakAndWeek[0]);
            week = Integer.parseInt(peakAndWeek[1]);
            author = eachSong.select(".Sub").select("[itemprop=byArtist]").text();
            String name = eachSong.select("a").select("span").text();
            String link[] = eachSong.select("a").attr("href").split("/");
            id = Integer.parseInt(link[4]);
            resultList.add(new RankBean(name, author, id, rank, week, peak, lastWeek));
        }
        return resultList;
    }


}
