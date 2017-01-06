package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter{

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    @Override
    public void write(int c) throws IOException
    {
        System.out.println((char) c);
        super.write(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        String s = "";
        for (int i = off; i < off + len; i++)
            s += cbuf[i];
        System.out.println(s);
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        System.out.println(str.substring(off, off + len));
        super.write(str, off, len);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    public static void main(String[] args) throws IOException
    {
        char[] chars = "chars123456789".toCharArray();

        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("d:/c.txt");

//        fileConsoleWriter.write("string");
//        fileConsoleWriter.write("string", 2, 4);
//        fileConsoleWriter.write(123456789);
        fileConsoleWriter.write(chars);
//        fileConsoleWriter.write(chars, 2, 4);

        fileConsoleWriter.close();
    }
}
