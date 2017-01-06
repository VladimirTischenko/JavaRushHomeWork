package com.javarush.test;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Test{
    public static class Stock extends HashMap
    {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
        }

        public Stock(String name, String symbol, double change) {
            put("name", name);
            put("symbol", symbol);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03));

        return stocks;
    }

    public static void printStocks(List<Stock> stocks) {
        double[] filelimits = {0d};
        String[] filepart = {"closed {4}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Object[] testArgs = {name, symbol, open, last, change};
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        printStocks(stocks);
    }
}
