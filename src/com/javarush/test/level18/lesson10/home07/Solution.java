package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(fileInputStream));
        ArrayList<String> list = new ArrayList<>();
        String s = "";
        while ((s = bufferedReader1.readLine()) != null)
            list.add(s);
        fileInputStream.close();
        bufferedReader1.close();

        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++)
            arrayList.add(Integer.valueOf(list.get(i).substring(0, list.get(i).indexOf(' '))));

        for (int i = 0; i < list.size(); i++)
            if (Integer.parseInt(args[0]) == arrayList.get(i))
                System.out.println(list.get(i));
    }
}
