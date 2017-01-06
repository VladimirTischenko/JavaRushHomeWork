package com.javarush.test.level05.lesson12.bonus01;

import java.io.*;
import java.util.Scanner;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два числа с клавиатуры и выводит их сумму на экран.
*/

public class Solution
{
   public static void main(String[] args) throws Exception
    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int a = reader.read();
//        int b = reader.read();

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = a + b;
        System.out.println("Sum = " + sum);
    }
}
