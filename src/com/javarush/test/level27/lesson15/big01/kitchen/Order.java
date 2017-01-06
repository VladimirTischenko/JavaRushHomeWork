package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 07.08.16.
 */
public class Order {
    Tablet tablet;
    List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) return "";
        StringBuilder builder = new StringBuilder();
        for (Dish dish : dishes)
            builder.append(dish + ", ");
        builder.delete(builder.length() - 2, builder.length());
        System.out.println(builder);
//        return "Your order: [" + builder + "] of Tablet{number=" + tablet.number + "}";
        return "Your order: [" + builder + "] of Tablet{number=" + tablet.number + "}";
    }
}
