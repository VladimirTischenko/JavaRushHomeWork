package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 28.07.16.
 */
public class CurrencyManipulatorFactory {
    private static final CurrencyManipulatorFactory instance = new CurrencyManipulatorFactory();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulatorFactory getInstance()
    {
        return instance;
    }

    static Map<String, CurrencyManipulator> currencyManipulatorMap = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (currencyManipulatorMap.containsKey(currencyCode)) return currencyManipulatorMap.get(currencyCode);
        else {
            CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
            currencyManipulatorMap.put(currencyCode, manipulator);
            return manipulator;
        }
    }

    public static Collection getAllCurrencyManipulators() {
        Collection<String> collection = new ArrayList<>();
        for (Map.Entry entry : currencyManipulatorMap.entrySet())
            collection.add(entry.getKey().toString());
        return collection;
    }
}
