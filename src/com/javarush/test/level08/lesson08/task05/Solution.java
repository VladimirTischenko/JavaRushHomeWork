package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        removeTheFirstNameDuplicates(createMap());

    }

    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("фамилия0", "имя0");
        map.put("фамилия1", "имя1");
        map.put("фамилия2", "имя2");
        map.put("фамилия3", "имя3");
        map.put("фамилия4", "имя4");
        map.put("фамилия5", "имя4");
        map.put("фамилия6", "имя6");
        map.put("фамилия7", "имя7");
        map.put("фамилия8", "имя6");
        map.put("фамилия9", "имя7");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> copy = new ArrayList<>();

        for (Map.Entry<String, String> pair : map.entrySet())
            list.add(pair.getValue());

        for (int i = 0; i < list.size(); i++)
        {
            for (int j = i + 1; j < list.size(); j++)
            {
                if (list.get(i).equals(list.get(j)))
                    copy.add(list.get(i));
            }
        }

        for (int i = 0; i < copy.size(); i++)
            removeItemFromMapByValue(map, copy.get(i));
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
