package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Admin on 21.04.16.
 */
public class Earth implements Planet
{
    private static Earth instance;
    private Earth(){}
    public static Earth getInstance(){
        if (instance == null)
            instance = new Earth();
        return instance;
    }
}
