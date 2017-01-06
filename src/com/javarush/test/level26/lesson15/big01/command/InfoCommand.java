package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

/**
 * Created by Admin on 29.07.16.
 */
class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));

        Collection<String> collection = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        CurrencyManipulator manipulator = null;
        int count = 0;
        for (String s : collection) {
            manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(s);
            if (manipulator.hasMoney() && manipulator.getTotalAmount() > 0) {
                ConsoleHelper.writeMessage(s + " - " + manipulator.getTotalAmount());
                ++count;
            }
        }
        if (collection.isEmpty() || count == 0)
            ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
