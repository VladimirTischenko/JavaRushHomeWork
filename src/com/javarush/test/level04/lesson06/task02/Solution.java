package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e, f;
        if (a > b)
            e = a;
        else
            e = b;
        if (c > d)
            f = c;
        else
            f = d;
        if (e > f)
            System.out.println(e);
        else
            System.out.println(f);
    }
}
