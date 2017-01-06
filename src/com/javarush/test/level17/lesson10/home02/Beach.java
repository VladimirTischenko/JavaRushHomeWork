package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o)
    {
//        int result = name.compareTo(o.name);
//        if (result != 0) return result;
        if (distance != o.distance) return (distance < o.distance) ? - 1 : 1;
        if (quality != o.quality) return (quality < o.quality) ? 1 : - 1;
        return 0;
    }

    public static void main (String[] afrs) {
        TreeSet<Beach> beaches = new TreeSet<>();
        Beach beach1 = new Beach("Verbnoe", 10, 10);
        Beach beach2 = new Beach("Raduzhnoe", 20, 15);
        Beach beach3 = new Beach("Verbnoe", 9, 10);
        Beach beach4 = new Beach("Verbnoe", 10, 12);
        beaches.add(beach1);
        beaches.add(beach2);
        beaches.add(beach3);
        beaches.add(beach4);
        for(Beach iter : beaches) {
            System.out.println(iter.name + " " + iter.distance + " " + iter.quality);
        }
    }
}
