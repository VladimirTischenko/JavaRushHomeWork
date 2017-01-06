package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

/**
 * Created by Admin on 07.08.16.
 */
public enum Dish {
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString() {
        String allDishes = Arrays.toString(Dish.values());
        return allDishes.substring(1, allDishes.length() - 1);
    }
}
