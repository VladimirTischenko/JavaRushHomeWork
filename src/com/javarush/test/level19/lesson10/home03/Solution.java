package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        while ((s = bufferedReader.readLine()) != null){
            String[] strings = s.split(" ");
            PEOPLE.add(new Person(getname(strings), getbirthday(strings)));
        }
        bufferedReader.close();
        fileReader.close();
    }

    private static Date getbirthday(String[] strings)
    {
        int year = Integer.parseInt(strings[strings.length - 1]) - 1900;
        int month = Integer.parseInt(strings[strings.length - 2]) - 1;
        int date = Integer.parseInt(strings[strings.length - 3]);
        Date birthday = new Date(year, month, date);
        return birthday;
    }

    private static String getname(String[] strings)
    {
        String name = strings[0];
        for (int i = 1; i < strings.length - 3; i++)
            name += " " + strings[i];
        return name;
    }

}
