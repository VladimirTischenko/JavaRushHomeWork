package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось:
Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human Viktor = new Human();
        Viktor.name = "Виктор";
        Viktor.sex = true;
        Viktor.age = 66;
        System.out.println(Viktor);

        Human Sergei = new Human();
        Sergei.name = "Сергей";
        Sergei.sex = true;
        Sergei.age = 60;
        System.out.println(Sergei);

        Human Faina = new Human();
        Faina.name = "Фаина";
        Faina.sex = false;
        Faina.age = 66;
        System.out.println(Faina);

        Human Lubov = new Human();
        Lubov.name = "Любовь";
        Lubov.sex = false;
        Lubov.age = 59;
        System.out.println(Lubov);

        Human Vladimir = new Human();
        Vladimir.name = "Владимир";
        Vladimir.sex = true;
        Vladimir.age = 33;
        Vladimir.father = Viktor;
        Vladimir.mother = Faina;
        System.out.println(Vladimir);

        Human Olga = new Human();
        Olga.name = "Ольга";
        Olga.sex = false;
        Olga.age = 26;
        Olga.father = Sergei;
        Olga.mother = Lubov;
        System.out.println(Olga);

        Human Kate = new Human();
        Kate.name = "Катя";
        Kate.sex = false;
        Kate.age = 3;
        Kate.father = Vladimir;
        Kate.mother = Olga;
        System.out.println(Kate);

        Human Vera = new Human();
        Vera.name = "Вера";
        Vera.sex = false;
        Vera.age = 0;
        Vera.father = Vladimir;
        Vera.mother = Olga;
        System.out.println(Vera);

        Human Nadya = new Human();
        Nadya.name = "Надя";
        Nadya.sex = false;
        Nadya.age = 0;
        Nadya.father = Vladimir;
        Nadya.mother = Olga;
        System.out.println(Nadya);

    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        Human father;
        Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
