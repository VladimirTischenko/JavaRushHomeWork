package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Admin on 28.07.16.
 */
public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    static String s = "";

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String s = "";
        try {
            s = reader.readLine();
            if (s.equalsIgnoreCase("exit")) throw new InterruptOperationException();
        }
        catch (IOException e) {}
        return s;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage(res.getString("choose.currency.code"));
            s = readString();
            if (s.length() == 3) return s.toUpperCase();
            else ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        String[] strings = new String[2];
        String s = "";
        while (true) {
            String string = res.getString("choose.denomination.and.count.format");
            ConsoleHelper.writeMessage(String.format(string, s));
            try {
                s = readString();
                strings = s.split(" ");
                int number0 = Integer.parseInt(strings[0]);
                int number1 = Integer.parseInt(strings[1]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
                continue;
            }
            catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (strings.length == 2) return strings;
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        Operation operation = null;
        while (true) {
            ConsoleHelper.writeMessage(res.getString("choose.operation"));
            ConsoleHelper.writeMessage(res.getString("operation.INFO"));
            ConsoleHelper.writeMessage(res.getString("operation.DEPOSIT"));
            ConsoleHelper.writeMessage(res.getString("operation.WITHDRAW"));
            ConsoleHelper.writeMessage(res.getString("operation.EXIT"));
            String s = "";
            s = readString();
            try {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(s));
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return operation;
    }
}
