package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        ArrayList<String> stringArrayList1 = new ArrayList<>();
        ArrayList<String> stringArrayList2 = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        FileReader fileReader1 = new FileReader(fileName1);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        String line;
        while ((line = bufferedReader1.readLine()) != null)
            stringArrayList1.add(line);
        bufferedReader1.close();
        fileReader1.close();

        FileReader fileReader2 = new FileReader(fileName2);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        while ((line = bufferedReader2.readLine()) != null)
            stringArrayList2.add(line);
        bufferedReader2.close();
        fileReader2.close();

        comparison(stringArrayList1, stringArrayList2);

        for (int i = 0; i < lines.size(); i++)
            System.out.println(lines.get(i).type + " " + lines.get(i).line);
    }

    private static void comparison(ArrayList<String> stringArrayList1, ArrayList<String> stringArrayList2)
    {
        int i = 0;
        int j = 0;

        while (i < stringArrayList1.size() && j < stringArrayList2.size()) {
            if (stringArrayList1.get(i).equals(stringArrayList2.get(j))){
                lines.add(new LineItem(Type.SAME, stringArrayList1.get(i)));
                i++;
                j++;
            } else {
                if (stringArrayList1.get(i).equals(stringArrayList2.get(j + 1))) {
                    lines.add(new LineItem(Type.ADDED, stringArrayList2.get(j)));
                    j++;
                } else {
                    lines.add(new LineItem(Type.REMOVED, stringArrayList1.get(i)));
                    i++;
                }
            }
        }

        while (i < stringArrayList1.size() && j == stringArrayList2.size()) {
            lines.add(new LineItem(Type.REMOVED, stringArrayList1.get(i)));
            i++;
        }

        while (i == stringArrayList1.size() && j < stringArrayList2.size()) {
            lines.add(new LineItem(Type.ADDED, stringArrayList2.get(j)));
            j++;
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
