package com.javarush.test.level08.lesson08.task04;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main (String[] args)
    {
        removeAllSummerPeople(createMap());
    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone0", new Date("JUNE 1 1980"));
        map.put("Stallone1", new Date("Jul 2 1981"));
        map.put("Stallone2", new Date("Aug 3 1982"));
        map.put("Stallone3", new Date("Sep 4 1983"));
        map.put("Stallone4", new Date("Oct 5 1984"));
        map.put("Stallone5", new Date("Nov 6 1985"));
        map.put("Stallone6", new Date("Dec 7 1986"));
        map.put("Stallone7", new Date("Jun 8 1987"));
        map.put("Stallone8", new Date("Feb 9 1988"));
        map.put("Stallone9", new Date("Mar 10 1989"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        HashMap<String, Date> mapCopy = new HashMap<String, Date>(map);

        for (Map.Entry<String, Date> pair : mapCopy.entrySet())
        {
            int month = pair.getValue().getMonth();

            if (month >= 5 && month <= 7)
                map.remove(pair.getKey());
        }
    }
}
