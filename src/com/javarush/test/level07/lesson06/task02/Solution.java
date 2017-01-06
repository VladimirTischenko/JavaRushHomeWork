package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
            list.add(reader.readLine());
//        String s0 = list.get(0);
//        String s1 = list.get(1);
//        String s2 = list.get(2);
//        String s3 = list.get(3);
//        String s4 = list.get(4);

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++)
            arr[i] = list.get(i).length();

//        arr[0] = s0.length();
//        arr[1] = s1.length();
//        arr[2] = s2.length();
//        arr[3] = s3.length();
//        arr[4] = s4.length();

        int max = arr[0];
        for (int i = 1; i < 5; i++)
            if (arr[i] > max)
                max = arr[i];

        for (int i = 0; i < 5; i++)
        {
            if (arr[i] == max)
                System.out.println(list.get(i));
        }
    }
}
