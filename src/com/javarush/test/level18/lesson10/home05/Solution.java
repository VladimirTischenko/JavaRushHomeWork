package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        String s = "";
        while (fileInputStream.available() > 0) s += (char) fileInputStream.read();
        fileInputStream.close();

        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        int position = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ' ') count++;
        for (int i = 0; i <= count; i++) {
            if (s.indexOf(' ', position) != - 1){
                list.add(s.substring(position, s.indexOf(' ', position)));
                position = s.indexOf(' ', position) + 1;
            }
            else list.add(s.substring(position, s.length()));
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
            arrayList.add((int) Math.round(Double.valueOf(list.get(i))));

        String s1 = "";
        for (int i = 0; i < list.size(); i++)
            s1 += arrayList.get(i) + " ";

        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        for (int i = 0; i < s1.length(); i++)
            fileOutputStream.write(s1.charAt(i));
        fileOutputStream.close();
    }
}
