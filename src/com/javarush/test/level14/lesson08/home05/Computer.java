package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Admin on 13.04.16.
 */
public class Computer
{
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    public Computer()
    {
        this.getKeyboard();
        this.getMouse();
        this.getMonitor();
    }

    public Keyboard getKeyboard()
    {
        Keyboard keyboard = new Keyboard();
        return keyboard;
    }

    public Mouse getMouse()
    {
        Mouse mouse = new Mouse();
        return mouse;
    }

    public Monitor getMonitor()
    {
        Monitor monitor = new Monitor();
        return monitor;
    }
}
