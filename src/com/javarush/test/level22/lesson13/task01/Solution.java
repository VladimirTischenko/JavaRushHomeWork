package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens())
            list.add(tokenizer.nextToken());
        String[] strings = new String[list.size()];
        for (int i = 0; i < strings.length; i++)
            strings[i] = list.get(i);
        return strings;
    }

    public static void main(String[] args) {
        System.out.println(getTokens("level22.lesson13.task01", "."));
    }
}
