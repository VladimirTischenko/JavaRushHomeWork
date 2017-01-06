package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:/c.txt");
            InputStream inputStream = new FileInputStream("d:/c.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Vladimir");
            user.setLastName("Tischenko");
            user.setBirthDate(new Date("1982 Oct 30"));
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);

            User user2 = new User();
            user2.setFirstName("Ekaterina");
            user2.setLastName("Tischenko");
            user2.setBirthDate(new Date("2012 Dec 06"));
            user2.setMale(false);
            user2.setCountry(User.Country.OTHER);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
//            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.users.get(1).getFirstName().equals(user2.getFirstName()));
            System.out.println(loadedObject.users.get(1).getLastName().equals(user2.getLastName()));
            System.out.println(loadedObject.users.get(1).getBirthDate().equals(user2.getBirthDate()));
            System.out.println(loadedObject.users.get(1).isMale() == (user2.isMale()));
            System.out.println(loadedObject.users.get(1).getCountry().equals(user2.getCountry()));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);

            for(int i = 0; i < users.size(); i++) {
                printWriter.write(users.get(i).getFirstName());
                printWriter.write("\n");
                printWriter.write(users.get(i).getLastName());
                printWriter.write("\n");
                printWriter.write(users.get(i).getBirthDate().toString());
                printWriter.write("\n");
                printWriter.write(String.valueOf(users.get(i).isMale()));
                printWriter.write("\n");
                printWriter.write(users.get(i).getCountry().toString());
                printWriter.write("\n");

                printWriter.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while (bufferedReader.ready()) {
                User user = new User();

                user.setFirstName(bufferedReader.readLine());
                user.setLastName(bufferedReader.readLine());

                String date = bufferedReader.readLine();
                user.setBirthDate(new Date(date.substring(date.length() - 4) + date.substring(3, 10)));

                user.setMale(Boolean.parseBoolean(bufferedReader.readLine()));

                String stringCountry = bufferedReader.readLine();
                User.Country country = null;
                if (stringCountry.equals("UKRAINE"))
                    country = User.Country.UKRAINE;
                if (stringCountry.equals("RUSSIA"))
                    country = User.Country.RUSSIA;
                if (stringCountry.equals("OTHER"))
                    country = User.Country.OTHER;
                user.setCountry(country);

                users.add(user);
            }
        }
    }
}
