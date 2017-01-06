package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(0.1, "first");
        labels.put(0.2, "second");
        labels.put(0.3, "third");
        labels.put(0.4, "forth");
        labels.put(0.5, "fifth");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
