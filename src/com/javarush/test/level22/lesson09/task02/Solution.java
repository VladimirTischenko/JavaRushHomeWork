package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry entry : params.entrySet())
            if (entry.getValue() != null)
                builder.append(entry.getKey().toString() + " = '" + entry.getValue().toString() + "' and ");
        if (builder.length() > 5)
            builder = new StringBuilder(builder.substring(0, builder.length() - 5));
        return builder;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", null);
        map.put("country", null);
        map.put("city", null);
        map.put("age", null);
        System.out.println(getCondition(map));
    }
}
