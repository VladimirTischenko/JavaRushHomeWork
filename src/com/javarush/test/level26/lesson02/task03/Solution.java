package com.javarush.test.level26.lesson02.task03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/
public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T> {
        Comparator[] comparatorList;

        public CustomizedComparator(Comparator... comparatorList) {
            this.comparatorList = comparatorList;
        }

        @Override
        public int compare(T o1, T o2) {
            for (Comparator comparator : comparatorList) {
                if (comparator.compare(o1, o2) != 0)
                    return comparator.compare(o1, o2);
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Comparator<Person> namePerson = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        };

        Comparator<Person> agePerson = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        };

        Comparator[] comparatorList = {namePerson, agePerson};
        Solution.CustomizedComparator customizedComparator = new CustomizedComparator(comparatorList);

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Vitja", 66));
        list.add(new Person("Faja", 67));
        list.add(new Person("Vova", 33));
        list.add(new Person("Sasha", 31));
        list.add(new Person("Sasha", 30));

        for (Person person : list)
            System.out.println(person.name + " " + person.age);

        Collections.sort(list, customizedComparator);

        System.out.println();
        for (Person person : list)
            System.out.println(person.name + " " + person.age);
    }
}
