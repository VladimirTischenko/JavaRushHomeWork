package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(createMap());
        System.out.println(getCountTheSameFirstName(createMap(), "Имя4"));
        System.out.println(getCountTheSameLastName(createMap(), "Фамилия1"));
    }

    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Фамилия1", "Имя1");
        hashMap.put("Фамилия2", "Имя2");
        hashMap.put("Фамилия3", "Имя3");
        hashMap.put("Фамилия4", "Имя4");
        hashMap.put("Фамилия5", "Имя5");
        hashMap.put("Фамилия6", "Имя6");
        hashMap.put("Фамилия7", "Имя7");
        hashMap.put("Фамилия8", "Имя8");
        hashMap.put("Фамилия9", "Имя9");
        hashMap.put("Фамилия10", "Имя10");

        return hashMap;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int i = 0;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (pair.getValue().equals(name))
                i++;
        }

        return i;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int i = 0;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (pair.getKey().equals(lastName))
                i++;
        }

        return i;
    }
}
