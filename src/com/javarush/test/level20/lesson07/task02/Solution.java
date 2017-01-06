package com.javarush.test.level20.lesson07.task02;

import java.io.*;

/* OutputToConsole
Класс OutputToConsole должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static String greeting = "Hello world";

    /**
     * OutputToConsole is the inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for the displaying [greeting] variable to the console by character.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int i = 8;

        /**
         * @param out A stream for an externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(i);
        }

        /**
         * @param in A stream for a de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            i = in.readInt();
        }

        /**
         * Class constructor specifying fake private field [i].
         */
        public OutputToConsole() {}

        public OutputToConsole(int ii) {
            this.i = ii;
        }

        /**
         * Outputs to the console a static field of Solution class [greeting].
         * Has to use [charAt] method of String class
         */
        public void outputToConsole(int ii) {
            for (int i = 0; i < greeting.length(); i++) {
                System.out.write(greeting.charAt(i));
            }
        }
    }

    public static void main(String[] args) throws IOException
    {

        OutputToConsole outputToConsole = new OutputToConsole(5);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/c.txt"));
        outputToConsole.writeExternal(objectOutputStream);
        objectOutputStream.close();

//        System.out.println(outputToConsole.i);

        OutputToConsole outputToConsoleLoaded = new OutputToConsole(2);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/c.txt"));
        try{
            outputToConsoleLoaded.readExternal(objectInputStream);
        } catch (ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
        }
        objectInputStream.close();

        System.out.println(outputToConsoleLoaded.i);
    }

}