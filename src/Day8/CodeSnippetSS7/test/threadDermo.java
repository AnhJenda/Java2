package Day8.CodeSnippetSS7.test;

/*
    @author: Dinh Quang Anh
    Date   : 5/18/2022
    Project: Java2
*/
public class threadDermo extends Thread{
    public static void main(String args[]){
        ThreadDemo objTh =new ThreadDemo();
        Thread t=new Thread(objTh);
        try{
            t.start();
            System.out.println("Number of threads running:+ Thread.activeCount()");
            System.out.println("Iam in the main and waiting for the thread to finish");
            objTh.join();// objTh isaThread object
        }
        catch(InterruptedException e){
            System.out.println("Main thread is interrupted");
        }
    }
}