package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Date;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        int[] source = new int[N];

        for (int i = 0; i < N; i++)
            source[i] = i;

        ArrayList<Integer> findFigures = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (i == FiguresSum(i)) {
                findFigures.add(i);
                count++;
            }
        }

        int[] result = new int[count];

        for (int i = 0; i < findFigures.size(); i++)
            result[i] = findFigures.get(i);

        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);

        return result;
    }

    private static int FiguresSum(int i)
    {
        if (i == 0)
            return 1;

        String s = String.valueOf(i);
        int numberQuantity = s.length();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int j = 0; j < s.length(); j++)
            numbers.add(Character.getNumericValue(s.charAt(j)));

        ArrayList<Integer> powNumbers = new ArrayList<>();

        for (int j = 0; j < numbers.size(); j++)
            powNumbers.add((int) Math.pow(numbers.get(j), numberQuantity));

        int result = 0;
        for (int j = 0; j < powNumbers.size(); j++)
            result += powNumbers.get(j);

        return result;
    }

    public static void main(String[] args) {
        Date date0 = new Date();
        long memoryStart = Runtime.getRuntime().freeMemory();

        Solution solution = new Solution();
        Solution.getNumbers(100000);

        Date date1 = new Date();
        long memoryEnd = Runtime.getRuntime().freeMemory();
        long l = date1.getTime() - date0.getTime();
        long memory = memoryStart - memoryEnd;
        System.out.println((double) l/1000 + " sec.");
        System.out.println(memoryStart + " byte");
        System.out.println(memoryEnd + " byte");
        System.out.println(memory / 1024 + " kByte");
    }
}
