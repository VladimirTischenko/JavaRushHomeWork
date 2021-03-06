package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> family = new ArrayList<>();

        Human grandfather1 = new Human();
        family.add(grandfather1);
        grandfather1.name = "Viktor";
        grandfather1.sex = true;
        grandfather1.age = 66;

        Human grandfather2 = new Human();
        family.add(grandfather2);
        grandfather2.name = "Sergei";
        grandfather2.sex = true;
        grandfather2.age = 56;

        Human grandmother1 = new Human();
        family.add(grandmother1);
        grandmother1.name = "Faina";
        grandmother1.age = 66;

        Human grandmother2 = new Human();
        family.add(grandmother2);
        grandmother2.name = "Lubov";
        grandmother2.age = 56;

        Human father = new Human();
        family.add(father);
        father.name = "Vladimir";
        father.sex = true;
        father.age = 33;
        grandfather1.children.add(father);
        grandmother1.children.add(father);

        Human mother = new Human();
        family.add(mother);
        mother.name = "Olga";
        mother.age = 26;
        grandfather2.children.add(mother);
        grandmother2.children.add(mother);

        Human dother = new Human();
        family.add(dother);
        dother.name = "Katya";
        dother.age = 3;
        father.children.add(dother);
        mother.children.add(dother);

        Human sun = new Human();
        family.add(sun);
        sun.name = "Alex";
        sun.sex = true;
        sun.age = 2;
        father.children.add(sun);
        mother.children.add(sun);

        Human dother2 = new Human();
        family.add(dother2);
        dother2.name = "Angela";
        dother2.age = 1;
        father.children.add(dother2);
        mother.children.add(dother2);

        for (Human chlen : family)
            System.out.println(chlen);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
