package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        int firstTabIndex;
        int secondTabIndex;
        try {
            firstTabIndex = string.indexOf("\t");
            secondTabIndex = string.indexOf("\t", firstTabIndex + 1);
            if (secondTabIndex == -1)
                throw new TooShortStringException();
            if (secondTabIndex - 1 == firstTabIndex)
                string = "";
            else
                string = string.substring(firstTabIndex + 1, secondTabIndex);
        } catch (NullPointerException e) {
            throw new TooShortStringException();
        }
        return string;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
