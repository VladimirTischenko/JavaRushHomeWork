package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Admin on 29.07.16.
 */
interface Command {
    void execute() throws InterruptOperationException;
}
