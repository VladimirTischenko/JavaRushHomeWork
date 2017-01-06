package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные, но их
длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int i1 = s1.length();
        int i2 = s2.length();
        if (s1.equals(s2))
            System.out.println("Имена идентичны");
        else
            if (i1 == i2)
                System.out.println("Длины имен равны");
    }
}
