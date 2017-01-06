package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream1 = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream1);

        testString.printSomething();

        String string = byteArrayOutputStream.toString();

        System.setOut(printStream);

        string = advertising(string);

        System.out.println(string);
    }

    private static String advertising(String string)
    {
        String[] strings = string.split("\n");
        string = "";
        if (strings.length % 2 == 0)
            for (int i = 0; i < strings.length / 2; i++)
                string += strings[2 * i] + "\n" + strings[2 * i + 1] + "\n" + "JavaRush - курсы Java онлайн" + "\n";
        else {
            for (int i = 0; i < strings.length / 2; i++)
                string += strings[2 * i] + "\n" + strings[2 * i + 1] + "\n" + "JavaRush - курсы Java онлайн" + "\n";
            string += strings[strings.length - 1];
        }
        return string;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
