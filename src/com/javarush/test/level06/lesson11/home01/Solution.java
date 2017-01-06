package com.javarush.test.level06.lesson11.home01;

/* Класс Cat и статическая переменная catCount
В классе Cat создай статическую переменную public int catCount.
Создай конструктор [public Cat()]. Пусть при каждом создании кота (нового объекта Cat) статическая переменная
catCount увеличивается на 1. Создать 10 объектов Cat и вывести значение переменной catCount на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Cоздай тут 10 объектов Cat
        Cat cat01 = new Cat();
        Cat cat02 = new Cat();
        Cat cat03 = new Cat();
        Cat cat04 = new Cat();
        Cat cat05 = new Cat();
        Cat cat06 = new Cat();
        Cat cat07 = new Cat();
        Cat cat08 = new Cat();
        Cat cat09 = new Cat();
        Cat cat10 = new Cat();
        //Выведи тут на экран catCount
        System.out.println(Cat.catCount);
    }

    public static class Cat
    {
        //Cоздай тут статическую переменную
        public static int catCount;
        //Создай тут конструктор
        public Cat()
        {
            catCount++;
        }
    }

}
