package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Admin on 15.04.16.
 */
public class Singleton
{
    static Singleton singleton;
    private Singleton(){singleton = new Singleton();}
    static Singleton getInstance()
    {
        return singleton;
    }
}
