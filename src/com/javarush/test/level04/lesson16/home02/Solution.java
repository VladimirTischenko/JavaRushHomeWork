package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = sc.nextInt();
        if (i > j)
            if (i > k)
                if (j > k)
                    System.out.println(j);
                else
                    System.out.println(k);
            else
                System.out.println(i);
        else
            if (j > k)
                if (i > k)
                    System.out.println(i);
                else
                    System.out.println(k);
            else
                System.out.println(j);

    }
}
