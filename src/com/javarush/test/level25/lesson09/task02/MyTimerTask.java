package com.javarush.test.level25.lesson09.task02;

import java.util.TimerTask;

/**
 * Created by Admin on 16.07.16.
 */
public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
