package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 07.08.16.
 */
public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException { return reader.readLine(); }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        Dish[] dishs = Dish.values();
        List<Dish> dishList = new ArrayList<Dish>();
        while (true) {
            writeMessage("Please, choose dish for adding it to the order");
            for (int i = 0; i < dishs.length; ++i)
                System.out.println(dishs[i].toString());
            writeMessage("exit : ending of the order");
            String s = readString();
            if (s.equals("exit")) break;
            try { dishList.add(Dish.valueOf(s)); }
            catch (IllegalArgumentException e) { writeMessage("There is no such dish name, try again"); }
        }
        return dishList;
    }
}
