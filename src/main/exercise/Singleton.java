/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class Singleton {
    static volatile Singleton instance;

    private Singleton() {
        System.out.println("instance created");
    }

    static Singleton getInstance() {

        System.out.println(Thread.currentThread() + "got access to getInstance method");


            if (instance == null) {
                instance = new Singleton();

        System.out.println(Thread.currentThread() + "got access to instance object");
    }
        return instance;
    }

    static void hi() {
        System.out.println("hi, " + Thread.currentThread());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> Singleton.getInstance(),"1");
        Thread thread2 = new Thread(() -> Singleton.getInstance(), "2");
        Thread thread3 = new Thread(() -> Singleton.getInstance(), "3");
        Thread thread4 = new Thread(() -> {hi();Singleton.getInstance();}, "4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
