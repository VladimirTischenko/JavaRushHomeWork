package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        String s = " ";
        double countSpace = 0;
        int countAllSymbols = 0;
        while (fileInputStream.available() > 0) {
            int i = fileInputStream.read();
            for (int j = 0; j < s.length(); j++)
                if (i == s.charAt(j)) countSpace++;
            countAllSymbols++;
        }
        BigDecimal bigDecimal = new BigDecimal(countSpace / countAllSymbols * 100);
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
        fileInputStream.close();

    }
}
