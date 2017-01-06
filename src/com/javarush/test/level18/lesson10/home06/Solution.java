package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        ArrayList<Character> characters0 = new ArrayList<>();
        while (fileInputStream.available() > 0)
            characters0.add((char) fileInputStream.read());
        fileInputStream.close();

        ArrayList<Character> characters1 = new ArrayList<>();
        characters1.add(characters0.get(0));
        for (int i = 1; i < characters0.size(); i++)
        {
            if (characters1.contains(characters0.get(i))) ;
            else
                characters1.add(characters0.get(i));
        }

        for (int i = 0; i < characters1.size() - 1; i++){
            char min = characters1.get(i);
            int pos = i;
            for (int j = i + 1; j < characters1.size(); j++){
                if (characters1.get(j) < min) {
                    min = characters1.get(j);
                    pos = j;
                }
            }
            characters1.set(pos, characters1.get(i));
            characters1.set(i, min);
        }

        for (int i = 0; i < characters1.size(); i++)
        {
            int count = 0;
            for (int j = 0; j < characters0.size(); j++)
            {
                if (characters1.get(i) == characters0.get(j))
                    count++;
            }
            System.out.println(characters1.get(i) + " " + count);
        }
    }
}
