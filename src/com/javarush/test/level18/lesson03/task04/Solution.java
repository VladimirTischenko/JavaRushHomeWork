package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s);
        ArrayList<Integer> list = new ArrayList<>();
        while (inputStream.available() > 0) list.add(inputStream.read());
        int count = 0;
        for (int j = 1; j < list.size(); j++) {
            if (list.get(0) == list.get(j)) count++;
        }
        int minQuantity = count;
        for (int i = 1; i < list.size(); i++) {
            count = 0;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) count++;
            }
            if (count < minQuantity) minQuantity = count;
        }
        for (int i = 0; i < list.size(); i++) {
            count = 0;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) count++;
            }
            if (count == minQuantity) System.out.print(list.get(i) + " ");
        }
        inputStream.close();
    }
}
