package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    static String string = "";
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader1.readLine()) != null)
            changeling(line);
        bufferedReader1.close();
        fileReader.close();

        System.out.println(string);
    }

    private static void changeling(String line)
    {
        for (int i = line.length() - 1; i > -1; i--)
            string += line.charAt(i);
        string += "\n";
    }
}
