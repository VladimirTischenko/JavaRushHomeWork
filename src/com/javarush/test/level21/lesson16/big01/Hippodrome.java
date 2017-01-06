package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Admin on 16.06.16.
 */
public class Hippodrome {
    static ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }
    }

    public void print(){
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        Horse winner = horses.get(0);
        double maxDistance = horses.get(0).distance;
        for (int i = 1; i < horses.size(); i++) {
            if (horses.get(i).distance > maxDistance) {
                maxDistance = horses.get(i).distance;
                winner = horses.get(i);
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        Horse horse0 = new Horse("Horse0", 3 , 0);
        Horse horse1 = new Horse("Horse1", 3 , 0);
        Horse horse2 = new Horse("Horse2", 3 , 0);

        horses.add(horse0);
        horses.add(horse1);
        horses.add(horse2);

        game.run();

        game.printWinner();
    }
}
