package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution implements Serializable{
    private static final long serialVersionUID = 1l;

    public static class Person implements Serializable {
        private static final long serialVersionUID = 2l;

        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person person = new Person("Vladimir", "Tischenko", "Ukraine", Sex.MALE);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/c.txt"));
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/c.txt"));
        person = (Person) objectInputStream.readObject();
        objectInputStream.close();
    }
}
