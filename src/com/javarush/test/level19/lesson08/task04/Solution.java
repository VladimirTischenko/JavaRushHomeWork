package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream1 = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream1);

        testString.printSomething();
        String string = byteArrayOutputStream.toString();

        System.setOut(printStream);

        String[] strings = string.split(" ");
        int first = Integer.parseInt(strings[0]);
        int second = Integer.parseInt(strings[2]);
        int result = 0;
        if ("+".equals(strings[1]))
            result = first + second;
        if ("-".equals(strings[1]))
            result = first - second;
        if ("*".equals(strings[1]))
            result = first * second;
        System.out.println(string.replace("\r\n", "") + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

