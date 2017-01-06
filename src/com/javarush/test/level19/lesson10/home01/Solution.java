package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList1 = new ArrayList<>();

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        while ((s = bufferedReader.readLine()) != null){
            stringArrayList.add(s.split(" ")[0]);
            doubleArrayList.add(Double.valueOf(s.split(" ")[1]));
        }
        bufferedReader.close();
        fileReader.close();

        for (int i = 0; i < stringArrayList.size(); i++)
            if (!stringArrayList1.contains(stringArrayList.get(i)))
                stringArrayList1.add(stringArrayList.get(i));

        Collections.sort(stringArrayList1);

        for (int i = 0; i < stringArrayList1.size(); i++){
            double sum = 0;
            for (int j = 0; j < stringArrayList.size(); j++)
                if (stringArrayList1.get(i).equals(stringArrayList.get(j)))
                    sum += doubleArrayList.get(j);
            System.out.println(stringArrayList1.get(i) + " " + sum);
        }
    }
}
