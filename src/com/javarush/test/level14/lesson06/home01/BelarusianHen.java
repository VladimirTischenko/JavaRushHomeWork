package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 11.04.16.
 */
public class BelarusianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 2;
    }
     String getDescription()
    {
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %d яиц в месяц.", Country.BELARUS, getCountOfEggsPerMonth());
    }
}
