package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний
вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается
адреса: null.
*/

public class Cat
{
    //напишите тут ваш код
    public void initialize(String name)
    {
    }

    public void initialize(String name, int weigth, int age)
    {
    }

    public void initialize(String name, int age)
    {
    }

    public void initialize(int weigth, String color)
    {
    }

    public void initialize(int weigth, String color, String address)
    {
    }

}
