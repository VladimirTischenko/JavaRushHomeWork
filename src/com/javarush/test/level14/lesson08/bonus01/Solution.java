package com.javarush.test.level14.lesson08.bonus01;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            InputStream inputStream = new FileInputStream("D:/qwe.txt");
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = null;
            s.equals("asd");
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new RuntimeException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new ClassNotFoundException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalArgumentException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IndexOutOfBoundsException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new NumberFormatException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new ArrayIndexOutOfBoundsException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IOException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
