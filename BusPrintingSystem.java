class BusPrinting {
    int available = 10;

    void blockSync(int seat) {
        System.out.println("Hello:" + Thread.currentThread().getName());
        System.out.println("Hello:" + Thread.currentThread().getName());
        System.out.println("Hello:" + Thread.currentThread().getName());
    }

    String name=thread.currentThread().getName();if(available>=seat)
    {
        System.out.println("Seats booked:" + name);
        available=available-seat;
        System.out.println("Available seats:"available);
    }

    else
    {
        System.out.println("Sorry:" + name + "Only" + available + "left");
    }

    synchronized(this)
    {
    }

    System.out.println("Bye:"+Thread.currentThread().getName());System.out.println("Bye:"+Thread.currentThread().getName());System.out.println("Bye:"+Thread.currentThread().getName());
}

public class NKO_103 extends Thread {
    int seat;

}

public class BusPrintingSystem {

    public static void main(String args[]{

        Thread t1=new Thread();
        Thread t2=new Thread();


        t1.setName("Onkar");
        t2.setName("Rahul");

        System.out.println(t1.getName());
        System.out.println(t2.getName());

        t1.seat=7;
        t2.seat=6;

        t1.start();
        t2.start();
    })

}
