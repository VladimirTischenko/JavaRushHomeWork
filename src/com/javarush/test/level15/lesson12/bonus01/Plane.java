package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Admin on 23.04.16.
 */
public class Plane implements Flyable
{
    int passangersQuantity;

    @Override
    public void fly()
    {

    }

    Plane(int i){
        passangersQuantity = i;
    }
}
