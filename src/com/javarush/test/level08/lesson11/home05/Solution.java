package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        ArrayList<Character> arrayList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++)
            arrayList.add(s.charAt(i));

        for (int i = 0; i < s.length() - 1; i++)
            if (arrayList.get(i).equals(' '))
                arrayList.set(i + 1, Character.toUpperCase(arrayList.get(i + 1)));

        String s2 = String.valueOf(arrayList.get(0));

        for (int i = 1; i < s.length(); i++)
            s2 += arrayList.get(i);

        System.out.println(s2);
    }


}
