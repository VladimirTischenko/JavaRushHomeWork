package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        ArrayList<byte[]> list = new ArrayList<>();
        while (true)
        {
            String s = reader.readLine();
            list.add(s.getBytes());
            if (s.equals("exit"))
                break;
        }

        OutputStream stream = new FileOutputStream(name);
        for (int i = 0; i < list.size(); i++)
        {
            stream.write(list.get(i));
            stream.write('\n');
        }
    }
}
