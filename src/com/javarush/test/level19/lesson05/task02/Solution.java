package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        String s = "";
        while (fileReader.ready())
            s += (char) fileReader.read();
        String[] strings = s.replaceAll("\\p{Punct}", " ").replaceAll("\n", " ").replaceAll("World", "world").split(" ");
        int count = 0;
        for (int i = 0; i < strings.length; i++){
            if ("world".equals(strings[i]))
                count++;
        }
        System.out.println(count);
        fileReader.close();
        bufferedReader.close();
    }
}
