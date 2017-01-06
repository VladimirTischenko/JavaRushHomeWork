package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
//        D:\\a.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        String s;
        while ( (s = bufferedReader.readLine() ) != null)
        {
            integerArrayList.add(Integer.parseInt(s));
        }

        ArrayList<Integer> integerArrayListEven = new ArrayList<>();
        for (int i = 0; i < integerArrayList.size(); i++)
            if (integerArrayList.get(i) % 2 == 0)
                integerArrayListEven.add(integerArrayList.get(i));

        for (int i = 0; i < integerArrayListEven.size(); i++)
        {
            int min = integerArrayListEven.get(i);
            int pos = i;
            for (int j = i + 1; j < integerArrayListEven.size(); j++)
            {
                if (integerArrayListEven.get(j) < min)
                {
                    min = integerArrayListEven.get(j);
                    pos = j;
                }
            }
            integerArrayListEven.set(pos, integerArrayListEven.get(i));
            integerArrayListEven.set(i, min);
        }

        for (int i = 0; i < integerArrayListEven.size(); i++)
            System.out.println(integerArrayListEven.get(i));
    }
}
