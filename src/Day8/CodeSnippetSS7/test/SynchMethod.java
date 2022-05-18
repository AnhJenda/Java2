package Day8.CodeSnippetSS7.test;

/*
    @author: Dinh Quang Anh
    Date   : 5/18/2022
    Project: Java2
*/
class One{
    // This method is synchronized to use the thread safely
    synchronized void display(int num){
        System.out.print(""+num);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("done");
    }
}
class Two extends Thread {
    int number;
    One objOne;

    public Two(One one_num, int num) {
        objOne = one_num;
        number = num;
    }

    public void run() {
        // Invoke the synchronized method
        objOne.display(number);
    }

    public class SynchMethod {
        public static void main(String args[]) {
            One objOne = new One();
            int digit = 10;
            Two objSynch1 = new Two(objOne, digit++);
            Two objSynch2 = new Two(objOne, digit++);
            Two objSynch3 = new Two(objOne, digit++);
            objSynch1.start();
            objSynch2.start();
            objSynch3.start();
        }
    }
}
