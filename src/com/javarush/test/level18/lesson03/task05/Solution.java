package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s);
        ArrayList<Integer> list0 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        while (inputStream.available() > 0) list0.add(inputStream.read());
        for (int i = 0; i < list0.size(); i++) {
            if (list1.contains(list0.get(i)));
            else list1.add(list0.get(i));
        }
        for (int i = 0; i < list1.size() - 1; i++) {
            int min = list1.get(i);
            int position = i;
            for (int j = i + 1; j < list1.size(); j++) {
                if (list1.get(j) < min) {
                    min = list1.get(j);
                    position = j;
                }
            }
            list1.set(position, list1.get(i));
            list1.set(i, min);
        }
        for (int i = 0; i < list1.size(); i++) System.out.print(list1.get(i) + " ");
        inputStream.close();
    }
}
