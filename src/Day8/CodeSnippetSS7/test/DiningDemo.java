package Day8.CodeSnippetSS7.test;
import java.io.*;
import java.util.*;
/*
    @author: Dinh Quang Anh
    Date   : 5/18/2022
    Project: Java2
*/
class Chopstick{
    boolean available;
    Chopstick(){
        this.available=true;
    }
    // Pick up the chopsticks
    public synchronized void takeUp(){
        while(!available){
            try{
                System.out.println("Waiting to eat ...");
                // Enter the waiting queue
                wait();
            }catch(InterruptedException e){}
        }
        available=false;
    }
    public synchronized void putDown(){
        available=true;
    }
}
class Philosopher extends Thread {
    Chopstick left;
    Chopstick right;
    int ID;

    public Philosopher(Chopstick left, Chopstick right, int ID) {
        this.left = left;
        this.right = right;
        this.ID = ID + 1;
    }

    // Dining
    public void eat() {
        left.takeUp();
        right.takeUp();
        System.out.println(ID + ":The Philosopher is Dining");
    }

    public void think() {
        left.putDown();
        right.putDown();
        System.out.println(ID + ":The Philosopher is Thinking");
    }

    public void run() {
        while (true) {
            eat();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            think();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ee) {

            }
        }
    }
    public class DiningDemo {
        public static void main(String[] args) throws IOException {
            int i;
            Philosopher[] philosopher = new Philosopher[5];
            Chopstick[] chopstick = new Chopstick[5];
            for (i = 0; i < 5; i++) {
                chopstick[i] = new Chopstick();
            }
            for (i = 0; i < 5; i++) {
                philosopher[i] = new Philosopher(chopstick[i], chopstick[(i + 1) % 5], 1);
            }
        }
    }
}
