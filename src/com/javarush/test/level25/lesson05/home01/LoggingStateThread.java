package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Admin on 13.07.16.
 */
public class LoggingStateThread extends Thread{
    Thread thread;
    public LoggingStateThread(Thread target) {
        thread = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        Thread.State state = thread.getState();
        System.out.println(state);
//        if (state == Thread.State.valueOf("RUNNABLE")) {
//            System.out.println(Thread.State.valueOf("NEW"));
//            System.out.println(Thread.State.valueOf("RUNNABLE"));
//        }
//        if (state == Thread.State.valueOf("TERMINATED")) {
//            System.out.println(Thread.State.valueOf("NEW"));
//            System.out.println(Thread.State.valueOf("RUNNABLE"));
//            System.out.println(Thread.State.valueOf("TERMINATED"));
//        }
        while (thread.isAlive())
            if (thread.getState() != state) {
                state = thread.getState();
                System.out.println(state);
            }
        if (state != Thread.State.valueOf("NEW") && state != Thread.State.valueOf("TERMINATED"))
            System.out.println(thread.getState());

        Thread.currentThread().interrupt();
    }
}
