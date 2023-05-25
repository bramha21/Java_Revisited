package concurrency;

import java.util.Vector;

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Vector<Integer> sharedQueue = new Vector<>();
        int size = 4;

        Thread producerThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consumerThread = new Thread(new Consumer(sharedQueue,size), "Consumer");

        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {
    private final Vector<Integer> sharedQueue;
    private final int SIZE;

    public Producer(Vector<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Produced : " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            produce(i);
        }
    }

    private void produce(int i) {
        //wait if queue is full
        while (sharedQueue.size() == SIZE) {
            synchronized (sharedQueue) {
                System.out.println("The queue is full " + Thread.currentThread().getName() + " is waiting, size: " + sharedQueue.size());
            }
        }

        //producing element and notify consumers
        synchronized (sharedQueue) {
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}

class Consumer implements Runnable {
    private final Vector<Integer> sharedQueue;
    private final int SIZE;

    public Consumer(Vector<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
//                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int consume() throws InterruptedException {
        //wait if queue is empty
        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {
                System.out.println("The queue is empty " + Thread.currentThread().getName() + " is waiting, size: " + sharedQueue.size());
                sharedQueue.wait();
            }
        }

        //Otherwise consume the element and notify the waiting producer
        synchronized (sharedQueue) {
            sharedQueue.notifyAll();
            return sharedQueue.remove(0);
        }
    }
}
