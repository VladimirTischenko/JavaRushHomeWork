package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
//        list.add("Вишня");
//        list.add("1");
//        list.add("Боб");
//        list.add("3");
//        list.add("Яблоко");
//        list.add("2");
//        list.add("0");
//        list.add("Арбуз");
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> posIntegers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> posStrings = new ArrayList<>();

        for (int i = 0; i < array.length; i++)
            if (isNumber(array[i]) == true)
                {
                    integers.add(Integer.valueOf(array[i]));
                    posIntegers.add(i);
                }
            else
                {
                    strings.add(array[i]);
                    posStrings.add(i);
                }

        for (int i = 0; i < integers.size(); i++)
        {
            int max = integers.get(i);
            int pos = i;
            for (int j = i + 1; j < integers.size(); j++)
            {
                if (integers.get(j) > max)
                {
                    max = integers.get(j);
                    pos = j;
                }
            }
            integers.set(pos, integers.get(i));
            integers.set(i, max);
        }

        for (int i = 0; i < integers.size(); i++)
            array[posIntegers.get(i)] = String.valueOf(integers.get(i));

        for (int i = 0; i < strings.size() -1; i++)
        {
            String temp = null;
            for (int j = i + 1; j < strings.size(); j++)
            {
                if (isGreaterThan(strings.get(i),strings.get(j)) == true)
                {
                    temp = strings.get(i);
                    strings.set(i, strings.get(j));
                    strings.set(j, temp);
                }
            }
        }

        for (int i = 0; i < strings.size(); i++)
            array[posStrings.get(i)] = strings.get(i);
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
