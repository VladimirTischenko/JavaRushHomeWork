package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int[] ar = new int [5];
        ar[0] = Integer.parseInt(reader.readLine());
        ar[1] = Integer.parseInt(reader.readLine());
        ar[2] = Integer.parseInt(reader.readLine());
        ar[3] = Integer.parseInt(reader.readLine());
        ar[4] = Integer.parseInt(reader.readLine());

        for (int i = 0; i < 5; i++)
        {
            int min = ar[i];
            int pos = i;
            for (int j = i + 1; j < 5; j++)
            {
                if (ar[j] < min)
                {
                    min = ar[j];
                    pos = j;
                }
            }
            if (ar[i] > min)
            {
                ar[pos] = ar[i];
                ar[i] = min;
            }
        }

        System.out.println(ar[0]);
        System.out.println(ar[1]);
        System.out.println(ar[2]);
        System.out.println(ar[3]);
        System.out.println(ar[4]);
    }
}
