package com.javarush.test.level06.lesson08.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
boolean readBoolean() – читает с клавиатуры строку "true" или "false" и возвращает соответствующую логическую переменную true или false
Внимание: создавайте переменную для чтения данных с консоли (BufferedReader или Scanner) внутри каждого метода
*/

public class ConsoleReader
{
    public static void main(String[] args) throws Exception{
        System.out.println(readString());
        System.out.println(readInt());
        System.out.println(readDouble());
        System.out.println(readBoolean());

    }
    public static String readString() throws Exception
    {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return s;
    }

    public static int readInt() throws Exception
    {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        return i;
    }

    public static double readDouble() throws Exception
    {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        return d;
    }

    public static boolean readBoolean() throws Exception
    {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        Boolean b = false;
        for (; true;)
        {
            String strboolean = sc.nextLine();
            if (strboolean.equals("true"))
            {
                b = true;
                break;
            }
            else
            {
                if (strboolean.equals("false"))
                    {
                        b = false;
                        break;
                    }
            }
            System.out.println("enter \"true или false\"");
        }
        return b;
    }
}
