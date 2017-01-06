package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    static String stringForRecord = "";

    public static void main(String[] args) throws IOException
    {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] strings;
        while ((line = bufferedReader.readLine()) != null) {
            strings = line.split(" ");
            lengthCheck(strings);
        }
        bufferedReader.close();
        fileReader.close();

        stringForRecord = stringForRecord.substring(0, stringForRecord.length() - 1);

        FileWriter fileWriter = new FileWriter(args[1]);
        for (int i = 0; i < stringForRecord.length(); i++)
            fileWriter.write(stringForRecord.charAt(i));
        fileWriter.close();
    }

    private static void lengthCheck(String[] strings)
    {
        for (int i = 0; i < strings.length; i++)
            if (strings[i].length() > 6)
                stringForRecord += strings[i] + ",";
    }
}
