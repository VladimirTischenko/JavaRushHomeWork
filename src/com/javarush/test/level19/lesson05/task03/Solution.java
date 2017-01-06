package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        FileWriter fileWriter = new FileWriter(bufferedReader.readLine());
        String s = "";
        while (fileReader.ready())
            s += (char) fileReader.read();
        String[] strings = s.split(" ");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++){
            try
            {
                arrayList.add(Integer.parseInt(strings[i]));
            }catch (NumberFormatException e){}
        }
        String s1 = "";
        for (int i = 0; i < arrayList.size(); i++){
            s1 += String.valueOf(arrayList.get(i)) + " ";
        }
        for (int i = 0; i < s1.length(); i++){
            fileWriter.write(s1.charAt(i));
        }
        fileReader.close();
        fileWriter.close();
        bufferedReader.close();
    }
}
