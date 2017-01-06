package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String s = new String(bytes, "UTF-8");
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(args[1]);
        bytes = s.getBytes("Windows-1251");
        outputStream.write(bytes);
        outputStream.close();

        System.out.println(s);
    }
}
