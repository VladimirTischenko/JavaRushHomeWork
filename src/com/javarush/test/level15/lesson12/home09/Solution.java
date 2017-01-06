package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int parameterQuantity = 1;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '&')
                parameterQuantity ++;
        }

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> listNew = new ArrayList<>();
        int indexStart = s.indexOf("?");
        int indexEnd = s.indexOf("&");
        list.add(s.substring(indexStart + 1));
        if (parameterQuantity > 1)
        {
            for (int i = 0; i < parameterQuantity - 1; i++)
            {
                indexStart = s.indexOf("&", indexEnd);
                indexEnd = s.indexOf("&", indexEnd + 1);
                list.add(s.substring(indexStart + 1));
            }
        }

        for (int i = 0; i < list.size(); i++)
        {
            int indexCut = list.get(i).length();
            for (int j = 0; j < list.get(i).length(); j++)
            {
                if (list.get(i).charAt(j) == '&' || list.get(i).charAt(j) == '=')
                {
                    indexCut = j;
                    break;
                }
            }
            listNew.add(list.get(i).substring(0, indexCut));
        }

        boolean objInstanse = false;
        for (int i = 0; i < listNew.size(); i++)
        {
            if (listNew.get(i).equals("obj"))
            {
                objInstanse = true;
                break;
            }
        }

        String value = null;
        double valueDouble = 0;
        boolean valueType = false;
        if (objInstanse == true)
        {
            int indexObjStart = s.indexOf("obj");
            int indexObjEnd = s.indexOf("&", indexObjStart);
            value = s.substring(indexObjStart + 4, indexObjEnd);
            try {
                valueDouble = Double.parseDouble(value);
                valueType = true;
            }
            catch (Exception e) {
                valueType = false;
            }
        }

        for (int i = 0; i < listNew.size() - 1; i++){
            System.out.print(listNew.get(i) + " ");
        }
        System.out.println(listNew.get(listNew.size() - 1));

        if (objInstanse == true)
        {
            if (valueType == true)
                alert(valueDouble);
            else alert(value);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
