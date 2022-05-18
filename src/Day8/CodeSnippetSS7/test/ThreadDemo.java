package Day8.CodeSnippetSS7.test;

/*
    @author: Dinh Quang Anh
    Date   : 5/18/2022
    Project: Java2
*/
public class ThreadDemo extends Thread{
    public static void main(String args[]){
        ThreadDemo Obj = new ThreadDemo();
        Thread t =new Thread(Obj);
        System.out.println("The thread is alive:" + t.isAlive());
    }
}

