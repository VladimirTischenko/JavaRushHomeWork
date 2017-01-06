package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int chislo1 = Integer.parseInt(reader.readLine());
        int chislo2 = Integer.parseInt(reader.readLine());
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        for (int i = 1; i <= chislo1; i++)
        {
            if (chislo1 % i == 0)
                listA.add(i);
        }
        for (int i = 1; i <= chislo2; i++)
        {
            if (chislo2 % i == 0)
                listB.add(i);
        }
        int NOD = 0;
        for (int i = 0; i < listA.size(); i++)
        {
            for (int j = 0; j < listB.size(); j++)
            {
                if (listA.get(i) == listB.get(j))
                    NOD = listA.get(i);
            }
        }
        System.out.println(NOD);
    }
}
