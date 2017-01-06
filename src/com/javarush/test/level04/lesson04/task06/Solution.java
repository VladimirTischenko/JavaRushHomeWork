package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда»,
«четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args) throws Exception    {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String s;
        if (i < 1  || 7 < i)
            s = "такого дня недели не существует";
        else {
            if (i == 1)
                s = "понедельник";
            else {
                if (i == 2)
                    s = "вторник";
                else {
                    if (i == 3)
                        s = "среда";
                    else {
                        if (i == 4)
                            s = "четверг";
                        else {
                            if (i == 5)
                                s = "пятница";
                            else {
                                if (i == 6)
                                    s = "суббота";
                                else
                                    s = "воскресенье";
                            }
                        }
                    }
                }
            }
        }
        System.out.println(s);
    }
}