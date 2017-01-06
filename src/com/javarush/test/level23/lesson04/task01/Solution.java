package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution0 = new Solution();
        Solution solution1 = new Solution();
        solution0.innerClasses[0] = solution0.new InnerClass();
        solution0.innerClasses[1] = solution0.new InnerClass();
        solution1.innerClasses[0] = solution0.new InnerClass();
        solution1.innerClasses[1] = solution0.new InnerClass();
        Solution[] solutions = {solution0, solution1};
        return solutions;
    }

    public static void main(String[] args) {
        System.out.println(Solution.getTwoSolutions());
    }
}
