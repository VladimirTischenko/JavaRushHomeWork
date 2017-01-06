package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Admin on 10.08.16.
 */
public class MyThread extends Thread{
    static int priority;

    public MyThread() {
        setCyclicalPriority();
    }

    public MyThread(ThreadGroup group, String s) {
        super(group, s);
        setCyclicalPriority();
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setCyclicalPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        setCyclicalPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        setCyclicalPriority();
    }

    public MyThread(Runnable target)
    {
        super(target);
        setCyclicalPriority();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        setCyclicalPriority();
    }

    public MyThread(String name)
    {
        super(name);
        setCyclicalPriority();
    }

    private void setCyclicalPriority() {
        ++priority;
        if (priority == 11) priority = 1;
        this.setPriority(priority);
    }
}
