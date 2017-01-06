package com.javarush.test.level05.lesson05.task04;

/* Создать три объекта типа Cat
В методе main создать три объекта типа Cat и заполнить их данными.
Использовать класс Cat из первой задачи. Класс Cat создавать не надо.
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        cat1.name = "Vaska";
        cat1.age = 6;
        cat1.weight = 4;
        cat1.strength = 5;
        cat2.name = "Barsik";
        cat2.age = 4;
        cat2.weight = 3;
        cat2.strength = 6;
        cat3.name = "Murzik";
        cat3.age = 7;
        cat3.weight = 2;
        cat3.strength = 7;
    }

    public static class Cat {

        public static int count = 0;
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat() {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}
