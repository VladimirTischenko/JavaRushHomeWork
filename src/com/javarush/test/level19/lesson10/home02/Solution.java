package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList1 = new ArrayList<>();
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        ArrayList<Double> doubleArrayList1 = new ArrayList<>();

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

        for (int i = 0; i < stringArrayList1.size(); i++){
            double sum = 0;
            for (int j = 0; j < stringArrayList.size(); j++)
                if (stringArrayList1.get(i).equals(stringArrayList.get(j)))
                    sum += doubleArrayList.get(j);
            doubleArrayList1.add(sum);
        }

        double max = 0;
        for (int i = 0; i < doubleArrayList1.size(); i++)
            if (doubleArrayList1.get(i) > max)
                max = doubleArrayList1.get(i);

        for (int i = 0; i < doubleArrayList1.size(); i++)
            if (doubleArrayList1.get(i) == max)
                System.out.println(stringArrayList1.get(i));
    }
}
