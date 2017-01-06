package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        FileWriter fileWriter = new FileWriter(bufferedReader.readLine());
        bufferedReader.close();
        String s = "";
        while (fileReader.ready())
            s += (char) fileReader.read();
        fileReader.close();
        s = s.replace('.', '!');
        for (int i = 0; i < s.length(); i++)
            fileWriter.write(s.charAt(i));
        fileWriter.close();
    }
}
