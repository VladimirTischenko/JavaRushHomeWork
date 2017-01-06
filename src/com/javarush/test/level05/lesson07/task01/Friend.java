package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    //напишите тут ваш код
    private String filename = null;
    public void initialize(String name)
    {
        this.filename = name;
    }

    public void initialize(String name, int age)
    {
        this.filename = name;
    }

    public void initialize(String name, int age, int sex)
    {
        this.filename = name;
    }

}
