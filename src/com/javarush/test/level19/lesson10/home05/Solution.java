package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
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
        while ((line = bufferedReader.readLine()) != null)
            filterForRecord(line);
        bufferedReader.close();
        fileReader.close();

        FileWriter fileWriter = new FileWriter(args[1]);
        for (int i = 0; i < stringForRecord.length(); i++)
            fileWriter.write(stringForRecord.charAt(i));
        fileWriter.close();
    }

    private static void filterForRecord(String line)
    {
        String[] strings = line.split(" ");

        for (int i = 0; i < strings.length; i++)
            toCheckFigures(strings[i]);
    }

    private static void toCheckFigures(String string)
    {
        boolean b = false;

        for (int i = 0; i < string.length(); i++){
            try {
                Integer.parseInt(String.valueOf(string.charAt(i)));
                b = true;
            }
            catch (NumberFormatException e) {}
        }

        if (b)
            stringForRecord += string + " ";
    }
}
