package com.javarush.test.level25.lesson09.task01;

/**
 * Created by Admin on 16.07.16.
 */
public class SolutionUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof Error)
            System.out.println("Нельзя дальше работать");
        else if (e instanceof Exception)
            System.out.println("Надо обработать");
        else if (e instanceof Throwable)
            System.out.println("ХЗ");
    }
}
