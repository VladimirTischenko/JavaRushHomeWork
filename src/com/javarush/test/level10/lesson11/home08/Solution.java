package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList[] arrayList = new ArrayList[3];
        ArrayList<String> list0 = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list0.add("aaa");
        list0.add("bbb");
        list0.add("ccc");
        list1.add("ddd");
        list1.add("eee");
        list1.add("fff");
        list2.add("ggg");
        list2.add("hhh");
        list2.add("iii");

        arrayList[0]=list0;
        arrayList[1]=list1;
        arrayList[2]=list2;
        return arrayList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}