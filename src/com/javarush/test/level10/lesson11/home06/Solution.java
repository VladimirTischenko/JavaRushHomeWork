package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        Boolean sex;
        int age, height;
        String name, secondName, lastName;

        Human() {

        }
        Human(Boolean sex) {

        }
        Human(int age) {

        }
        Human(String name) {

        }
        Human(Boolean sex, int age) {

        }
        Human(Boolean sex, String name) {

        }
        Human(int age, String name) {

        }
        Human(int age, int height) {

        }
        Human(String name, String lastName) {

        }
        Human(Boolean sex, int age, String name) {

        }
    }
}
