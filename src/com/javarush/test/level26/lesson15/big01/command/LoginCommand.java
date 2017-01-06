package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by Admin on 31.07.16.
 */
public class LoginCommand implements Command{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        String cardNumber, pin;
        String validPin;
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            cardNumber = ConsoleHelper.readString();
            try { validPin = validCreditCards.getString(cardNumber); }
            catch (MissingResourceException exception) {
                String string = res.getString("not.verified.format");
                ConsoleHelper.writeMessage(String.format(string, cardNumber));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            break;
        }
        while (true) {
            pin = ConsoleHelper.readString();
            if (!pin.equals(validPin)) {
                String string = res.getString("not.verified.format");
                ConsoleHelper.writeMessage(String.format(string, cardNumber));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            break;
        }
        String string = res.getString("success.format");
        ConsoleHelper.writeMessage(String.format(string, cardNumber));
    }
}
