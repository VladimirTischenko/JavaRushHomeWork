package com.javarush.test.level25.lesson05.task01;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (int i = 0; i < threads.length; ++i) {
            switch (threads[i].getState().toString()) {
                case "NEW" :
                    threads[i].start();
                    break;
                case "WAITING" :
                    threads[i].interrupt();
                    break;
                case "TIMED_WAITING" :
                    threads[i].interrupt();
                    break;
                case "BLOCKED" :
                    threads[i].interrupt();
                    break;
                case "RUNNABLE" :
                    threads[i].isInterrupted();
                    break;
                case "TERMINATED" :
                    System.out.println(threads[i].getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Thread thread0 = new MyThread();
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        Thread thread3 = new MyThread();

        Thread[] threads = new Thread[1];
        threads[0] = thread0;

        thread0.start();

        int count = 0;
        for (int i = 0; i < 100000; ++i)
            count++;
//        thread0.wait();
        processThreads(threads);
    }
    
    static class MyThread extends Thread {
        @Override
        public void run()
        {
//            try
//            {
//                this.wait();
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
        }
    }
}
