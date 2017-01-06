package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException
    {
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        Properties properties1 = new Properties();
        properties1.load(new FileInputStream(fileName));

        for (Map.Entry entry : properties1.entrySet())
            properties.put(entry.getKey().toString(), entry.getValue().toString());
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);

        for (Map.Entry entry : properties.entrySet()) {
            printWriter.write(entry.getKey().toString());
            printWriter.write("\n");
            printWriter.write(entry.getValue().toString());
            printWriter.write("\n");

            printWriter.flush();
        }
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (bufferedReader.ready())
            properties.put(bufferedReader.readLine(), bufferedReader.readLine());
    }

    public static void main(String[] args) throws Exception
    {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();

        String fileName = "d:/c.txt";

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        FileInputStream fileInputStream = new FileInputStream(fileName);

        solution.save(fileOutputStream);
        fileOutputStream.flush();

        solution.load(fileInputStream);

        fileOutputStream.close();
        fileInputStream.close();
    }
}
