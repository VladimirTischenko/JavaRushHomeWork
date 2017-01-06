package com.javarush.test.level08.lesson11.home09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        isDateOdd("JANUARY 1 2000");
        isDateOdd("MAY 3 2020");
    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        boolean odd = true;

        SimpleDateFormat format = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH);

        Date dateDate = format.parse(date);

        Date dateDateStart = new Date();
        dateDateStart.setYear(dateDate.getYear());
        dateDateStart.setMonth(0);
        dateDateStart.setDate(-1);

        long time = dateDate.getTime() - dateDateStart.getTime();
        int quantityOfDays = (int) (time / (24 * 60 * 60 * 1000));

        if (quantityOfDays % 2 == 0)
            odd = false;

        return odd;
    }
}
