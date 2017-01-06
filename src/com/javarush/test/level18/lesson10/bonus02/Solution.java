package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        String[] correctArgs = partition(args);
        String id = changeLengthParameters(generateId(fileName), 8);
        String productName = changeLengthParameters(correctArgs[0], 30);
        String price = changeLengthParameters(correctArgs[1], 8);
        String quantity = changeLengthParameters(correctArgs[2], 4);
        String product = id + productName + price + quantity;
        write(fileName, product);
    }

    private static void write(String fileName, String product) throws IOException
    {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        fileOutputStream.write(product.getBytes());
        fileOutputStream.close();
    }

    private static String generateId(String fileName) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line;
        String lastLine = null;
        while ((line = bufferedReader.readLine()) != null)
            lastLine = line;
        bufferedReader.close();
        fileInputStream.close();

        return String.valueOf(Integer.parseInt(lastLine.substring(0, 8).trim()) + 1);
    }

    private static String changeLengthParameters(String parameter, int paramenerLength)
    {
        if (parameter.length() > paramenerLength)
            parameter = parameter.substring(0, paramenerLength);
        if (parameter.length() < paramenerLength)
            for (int i = parameter.length() + 1; i <= paramenerLength; i++)
                parameter += ' ';
        return parameter;
    }

    private static String[] partition(String[] args)
    {
        String[] correctArgs = new String[3];
        String productName = args[1];
        for (int i = 2; i < args.length - 2; i++)
        {
            productName += " " + args[i];
        }
        correctArgs[0] = productName;
        correctArgs[1] = args[args.length - 2];
        correctArgs[2] = args[args.length - 1];
        return  correctArgs;
    }
}
