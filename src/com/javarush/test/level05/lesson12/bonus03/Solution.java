package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;
import java.util.Scanner;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        for (; N <= 0;)
        {
            System.out.println("ввести с консоли число N > 0 !");
            N = Integer.parseInt(reader.readLine());
        }
        int maximum = Integer.parseInt(reader.readLine());
        for (int i = 1; i < N; i++)
        {
            int chislo = Integer.parseInt(reader.readLine());
            if (chislo > maximum)
                maximum = chislo;
        }
        System.out.println(maximum);
        //напишите тут ваш код
    }
}
