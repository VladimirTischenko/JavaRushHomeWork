package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 13.08.16.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
//    String userAgent = "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36";
    String userAgent = "Chrome/49.0.2623.112";
    String referer = "https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
//        try {
//            Document document = Jsoup.connect(URL_FORMAT).userAgent(userAgent).referrer(referer).get();
//            System.out.println(document.html());
//        }
//        catch (IOException e) {}
        return null;
    }

//    protected Document getDocument(String searchString, int page) throws IOException {
//
//    }

//    public static void main(String[] args) {
//        System.out.println(String.format(URL_FORMAT, 115, 3));
//    }
}
