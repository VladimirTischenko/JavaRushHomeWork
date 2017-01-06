package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{

        private final Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String lastName = scanner.next();
            String firstName = scanner.next();
            String middleName = scanner.next();
            int day = Integer.parseInt(scanner.next());
            int month = Integer.parseInt(scanner.next());
            int year = Integer.parseInt(scanner.next());
            Date birthDate = new Date(year - 1900, month - 1, day);
            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(new File("d:/b.txt"));
        PersonScanner personScanner = new PersonScannerAdapter(scanner);
        System.out.println(personScanner.read());
    }
}
