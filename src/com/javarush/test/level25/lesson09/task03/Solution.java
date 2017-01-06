package com.javarush.test.level25.lesson09.task03;

import java.util.ArrayList;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    ArrayList<Throwable> list = new ArrayList<>();
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        addException(e);
        for (int i = 0; i < list.size(); ++i)
            System.out.println(list.get(i));
    }

    private void addException(Throwable cause) {
        if (cause != null) {
            list.add(0, cause);
            addException(cause.getCause());
        }
    }

    public static void main(String[] args) throws Exception
    {
        Thread.currentThread().setUncaughtExceptionHandler(new Solution());
        throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
    }
}
