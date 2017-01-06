package com.javarush.test.level16.lesson13.home10;

import java.io.*;
import java.util.ArrayList;

/* Последовательный вывод файлов
1. Разберись, что делает программа.
2. В статическом блоке считай 2 имени файла firstFileName и secondFileName.
3. Внутри класса Solution создай нить public static ReadFileThread, которая реализует
интерфейс ReadFileInterface (Подумай, что больше подходит - Thread или Runnable).
3.1. Метод setFileName должен устанавливать имя файла, из которого будет читаться содержимое.
3.2. Метод getFileContent должен возвращать содержимое файла.
3.3. В методе run считай содержимое файла, закрой поток. Раздели пробелом строки файла.
4. Подумай, в каком месте нужно подождать окончания работы нити, чтобы обеспечить последовательный вывод файлов.
4.1. Для этого добавь вызов соответствующего метода.
Ожидаемый вывод:
[все тело первого файла]
[все тело второго файла]
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("Error:(68, 60) java: unreported exception java.io.FileNotFoundException; must be caught or declared to be thrownd");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public static interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        String fullFileName;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        @Override
        public void setFileName(String fullFileName)
        {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent()
        {
            File file = new File(fullFileName);
            String ss = null;
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String s;
                while ((s = reader.readLine()) != null) ss += s + " ";
                reader.close();
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Error:(68, 60) java: unreported exception java.io.FileNotFoundException; must be caught or declared to be thrownd");
            }
            catch (IOException e)
            {
                System.out.println("Error:(75, 40) java: unreported exception java.io.IOException; must be caught or declared to be thrown");
            }
            ss = ss.substring(4, ss.length() - 1);
            return ss;
        }
    }
}