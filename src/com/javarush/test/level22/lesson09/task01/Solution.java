package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader1.readLine();
        bufferedReader1.close();

        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder1 = new StringBuilder("");
        String line;
        while ((line = bufferedReader2.readLine()) != null)
            stringBuilder1.append(line + " ");
        bufferedReader2.close();

        String[] strings = stringBuilder1.toString().trim().split(" ");
        ArrayList<String> stringArrayList = new ArrayList<>();

        for (int i = 0; i < strings.length - 1; i++) {
            if (!stringArrayList.contains(strings[i])) {
                for (int j = i + 1; j < strings.length; j++) {
                    StringBuilder stringBuilder2 = new StringBuilder(strings[j]);
                    stringBuilder2.reverse();
                    if (strings[i].equals(stringBuilder2.toString())) {
                        stringArrayList.add(strings[i]);
                        stringArrayList.add(strings[j]);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < stringArrayList.size();) {
            Pair pair = new Pair();
            pair.first = stringArrayList.get(i);
            pair.second = stringArrayList.get(i + 1);
            result.add(pair);
            i += 2;
        }

        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
