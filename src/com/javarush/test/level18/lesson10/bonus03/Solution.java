package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    static String fileName;

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        fileName = bufferedReader.readLine();
        bufferedReader.close();

        ArrayList<String> arrayList = ArrayListWithoutId(args[1]);

        String product = "";
        if (args[0].equals("-u")){
            String[] correctArgs = partition(args);
            String id = String.format("%-8.8s", correctArgs[0]);
            String productName = String.format("%-30.30s", correctArgs[1]);
            String price = String.format("%-8.8s", correctArgs[2]);
            String quantity = String.format("%-4.4s", correctArgs[3]);
            product = id + productName + price + quantity;
        }

        write(arrayList, product);
    }

    private static void write(ArrayList<String> arrayList, String product) throws IOException
    {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        for (int i = 0; i < arrayList.size(); i++){
            fileOutputStream.write(arrayList.get(i).getBytes());
            fileOutputStream.write('\n');
        }
        fileOutputStream.write(product.getBytes());
        fileOutputStream.close();
    }


    private static String[] partition(String[] args)
    {
        String[] correctArgs = new String[4];
        correctArgs[0] = args[1];
        String productName = args[2];
        for (int i = 3; i < args.length - 2; i++)
        {
            productName += " " + args[i];
        }
        correctArgs[1] = productName;
        correctArgs[2] = args[args.length - 2];
        correctArgs[3] = args[args.length - 1];
        return  correctArgs;
    }

    private static ArrayList ArrayListWithoutId(String arg) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        ArrayList<String> arrayList = new ArrayList<>();
                String line;
        while ((line = bufferedReader.readLine()) != null)
            if (!line.substring(0, 8).trim().equals(arg))
                arrayList.add(line);;
        bufferedReader.close();
        fileInputStream.close();
        return arrayList;
    }
}
