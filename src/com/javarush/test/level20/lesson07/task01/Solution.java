package com.javarush.test.level20.lesson07.task01;

import java.io.*;

/* Externalizable для апартаментов
Реализуйте интерфейс Externalizable для класса Apartment
Подумайте, какие поля не нужно сериализовать.
*/
public class Solution {

    public static class Apartment implements Externalizable{

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException
        {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
        {
            address = (String) in.readObject();
            year = in.readInt();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Apartment apartment = new Apartment("Kyiv", 2016);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/c.txt"));
        objectOutputStream.writeObject(apartment);
        objectOutputStream.close();

        System.out.println(apartment.address + " : " + apartment.year);

        apartment.address = "Moscow";
        apartment.year = 2017;

        System.out.println(apartment.address + " : " + apartment.year);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/c.txt"));
        apartment = (Apartment) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(apartment.address + " : " + apartment.year);
    }
}
