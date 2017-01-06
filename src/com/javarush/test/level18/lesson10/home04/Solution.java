package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (fileInputStream1.available() > 0){
            arrayList.add(fileInputStream1.read());
        }
        fileInputStream1.close();

        FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        while (fileInputStream2.available() > 0)
            fileOutputStream.write(fileInputStream2.read());
        fileInputStream2.close();

        for (int i = 0; i < arrayList.size(); i++)
            fileOutputStream.write(arrayList.get(i));
        fileOutputStream.close();

        bufferedReader.close();
    }
}
