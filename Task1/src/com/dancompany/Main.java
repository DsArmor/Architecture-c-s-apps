package com.dancompany;

class Ball {

    private boolean isYours = true;

    public synchronized void ping() {
        if (isYours) {
            System.out.print("Ping ");
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            isYours = !isYours;
        }
        notify();
    }

    public synchronized void pong() {
        if (!isYours) {
            System.out.println("Pong");
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            isYours = !isYours;
        }
        notify();
    }
}

class Ping extends Thread {

    Ball ball;

    public Ping(Ball ball) {
        this.ball = ball;
    }

    public void run() {
        while (true) {
            ball.ping();
        }
    }

}

class Pong extends Thread {

    Ball ball;

    public Pong(Ball ball) {
        this.ball = ball;
    }

    public void run() {
        while (true) {
            ball.pong();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Nice to meet you");

        Ball ball = new Ball();
        Ping ping = new Ping(ball);
        Pong pong = new Pong(ball);

        new Thread(ping).start();
        new Thread(pong).start();
    }
}
