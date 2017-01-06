package com.javarush.test.level20.lesson07.task05;

import java.io.*;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Externalizable, Runnable {
    transient private Thread runner;
    private int speed;

    public Solution() {
        runner = new Thread(this);
        runner.start();
    }

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution solution = new Solution(1);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/c.txt"));
        objectOutputStream.writeObject(solution);
        objectOutputStream.flush();
        objectOutputStream.close();

        Solution newSolution = new Solution(2);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/c.txt"));
        newSolution = (Solution) objectInputStream.readObject();
        objectInputStream.close();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeInt(speed);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        speed = in.readInt();
    }
}
