package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {
        boolean b = false;
        int count = 0;
        for (int i = 0; i < telNumber.length(); i++)
            if (telNumber.charAt(i) == '-')
                count++;
        if (count < 3 && telNumber.matches("(\\+38)?\\(?[0-9]{1}\\-?[0-9]{1}\\-?[0-9]{1}\\)?[0-9]{1}\\-?[0-9]{1}\\-?[0-9]{1}\\-?[0-9]{1}\\-?[0-9]{1}\\-?[0-9]{1}\\-?[0-9]{1}$"))
            b = true;
        return b;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("(050)123-4567"));
        System.out.println(checkTelNumber("1-23456789-0"));
        System.out.println();
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
        System.out.println(checkTelNumber("-0501234567"));
        System.out.println(checkTelNumber("+38-(050)1234567"));
        System.out.println(checkTelNumber("+38((050)1234567"));
        System.out.println(checkTelNumber("+5(0--5)1234567"));
        System.out.println(checkTelNumber("7-4-4123689-5"));
    }
}