package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        double mediana = 0;
        int length = array.length;

        Arrays.sort(array);

        if (array.length % 2 == 1)
            mediana = array[length / 2];
        else mediana = ((double) (array[length / 2 - 1] + array[length / 2])) / 2;

        class InnerClass implements Comparable<InnerClass>{
            Integer value;
            double distanceFromMediana;

            public InnerClass(Integer value, double distanceFromMediana) {
                this.value = value;
                this.distanceFromMediana = distanceFromMediana;
            }

            @Override
            public int compareTo(InnerClass o) {
                return (int) (this.distanceFromMediana - o.distanceFromMediana);
            }
        }

        InnerClass[] innerClasses = new InnerClass[length];

        for (int i = 0; i < length; ++i)
            innerClasses[i] = new InnerClass(array[i], Math.abs(array[i] - mediana));

        Arrays.sort(innerClasses);

        for (int i = 0; i < length; ++i)
            array[i] = innerClasses[i].value;

        for (int i = 0; i < length; ++i)
            System.out.println(array[i]);

        return array;
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[10];

        for (int i = 0; i < ints.length; ++i)
            ints[i] = (int) (Math.random() * 10);

        Solution.sort(ints);

//        for (int i = 0; i < ints.length; ++i)
//            System.out.print(ints[i] + " ");
    }
}
