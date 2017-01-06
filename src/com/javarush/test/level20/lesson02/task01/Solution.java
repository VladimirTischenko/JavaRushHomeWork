package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

            if (ivanov.name.equals(somePerson.name))
                System.out.println("имена ivanov и somePerson равны");
            else
                System.out.println("имена ivanov и somePerson НЕ равны");

            if (ivanov.assets.size() == somePerson.assets.size())
                System.out.println("кол-во активов ivanov и somePerson равно : " + ivanov.assets.size());
            else
                System.out.println("кол-во активов ivanov и somePerson НЕ равно : " + ivanov.assets.size() + " и " + somePerson.assets.size());

            if (ivanov.assets.get(1).getName().equals(somePerson.assets.get(1).getName()))
                System.out.println("актив 1 ivanov и somePerson равен");
            else
                System.out.println("актив 1 ivanov и somePerson НЕ равен");

            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            PrintWriter printWriter = new PrintWriter(outputStream);

            printWriter.write(name);
            printWriter.write("\n");

            for (int i = 0; i < assets.size(); i++) {
                printWriter.write(assets.get(i).getName());
                printWriter.write("\n");
            }

            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            name = bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null)
                assets.add(new Asset(line));
        }
    }
}
