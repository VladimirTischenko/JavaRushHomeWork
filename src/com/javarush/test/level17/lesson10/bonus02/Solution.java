package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    static SimpleDateFormat dateFormat0 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);


    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        synchronized (allPeople)
        {
            if (args[0].equals("-c")) creation(args);
            if (args[0].equals("-u")) updates(args);
            if (args[0].equals("-d")) deletion(args);
            if (args[0].equals("-i")) information(args);
        }
    }

    private static void information(String[] args)
    {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int argsQuantity = args.length - 1;
        for (int i = 0; i < argsQuantity; i++) {
            if (allPeople.get(Integer.parseInt(args[1 + i])).getSex() == Sex.MALE)
                System.out.println(allPeople.get(Integer.parseInt(args[1 + i])).getName() + " " + "м" + " " + dateFormat1.format(allPeople.get(Integer.parseInt(args[1 + i])).getBirthDay()));
            if (allPeople.get(Integer.parseInt(args[1 + i])).getSex() == Sex.FEMALE)
                System.out.println(allPeople.get(Integer.parseInt(args[1 + i])).getName() + " " + "ж" + " " + dateFormat1.format(allPeople.get(Integer.parseInt(args[1 + i])).getBirthDay()));
        }
    }

    private static void deletion(String[] args)
    {
        int argsQuantity = args.length - 1;
        for (int i = 0; i < argsQuantity; i++) {
            allPeople.get(Integer.parseInt(args[1 + i])).setName(null);
            allPeople.get(Integer.parseInt(args[1 + i])).setSex(null);
            allPeople.get(Integer.parseInt(args[1 + i])).setBirthDay(null);
        }
    }

    private static void updates(String[] args) throws ParseException
    {
        int argsQuantity = (args.length - 1) / 4;
        for (int i = 0; i < argsQuantity; i++) {
            allPeople.get(Integer.parseInt(args[1 + 4 * i])).setName(args[2 + 4 * i]);
            if (args[3 + 4 * i].equals("м")) allPeople.get(Integer.parseInt(args[1 + 4 * i])).setSex(Sex.MALE);
            if (args[3 + 4 * i].equals("ж")) allPeople.get(Integer.parseInt(args[1 + 4 * i])).setSex(Sex.FEMALE);
            allPeople.get(Integer.parseInt(args[1 + 4 * i])).setBirthDay(dateFormat0.parse(args[4 + 4 * i]));
        }
    }

    private static void creation(String[] args) throws ParseException
    {
        int argsQuantity = (args.length - 1) / 3;
        for (int i = 0; i < argsQuantity; i++) {
            if (args[2 + 3 * i].equals("м")) allPeople.add(Person.createMale(args[1 + 3 * i], dateFormat0.parse(args[3 + 3 * i])));
            if (args[2 + 3 * i].equals("ж")) allPeople.add(Person.createFemale(args[1 + 3 * i], dateFormat0.parse(args[3 + 3 * i])));
            System.out.println(allPeople.size() - 1);
        }
    }
}
