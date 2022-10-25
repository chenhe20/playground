/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class synTest {

    private static ThreadLocal<Integer> num = ThreadLocal.withInitial(() -> 1);

    static synchronized void test0() throws InterruptedException {
            System.out.println(Thread.currentThread() + "test0");
            Thread.sleep(100);
            System.out.println(Thread.currentThread() + "test0 wakes");
    }

    static synchronized void test1() throws InterruptedException{
        System.out.println(Thread.currentThread() + "test1");
        Thread.sleep(100);
        System.out.println(Thread.currentThread() + "test1 wakes");
    }

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            try {
                test0();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            num.set(num.get() + 2);
            System.out.println(Thread.currentThread() + "num value added, now is: " + num.get());
        }, "1");

        Thread thread2 = new Thread(() -> {
            try {
                synTest.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            num.set(num.get() + 1);
            System.out.println(Thread.currentThread() + "num value added, now is: " + num.get());
        }, "2");

        Thread thread3 = new Thread(() -> {
            try {
                test0();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            num.set(num.get() + 1);
            System.out.println(Thread.currentThread() + "num value added, now is: " + num.get());
        }, "3");

        thread1.start();
        thread3.start();
        thread2.start();

    }
}
