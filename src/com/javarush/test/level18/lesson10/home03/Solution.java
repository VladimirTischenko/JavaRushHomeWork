package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        String fileName3 = bufferedReader.readLine();

        FileInputStream fileInputStream21 = new FileInputStream(fileName2);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        while (fileInputStream21.available() > 0)
            fileOutputStream.write(fileInputStream21.read());
        fileInputStream21.close();

        fileOutputStream.write('\n');
        FileInputStream fileInputStream31 = new FileInputStream(fileName3);
        while (fileInputStream31.available() > 0)
            fileOutputStream.write(fileInputStream31.read());
        fileInputStream31.close();
        fileOutputStream.close();
        bufferedReader.close();
    }
}
