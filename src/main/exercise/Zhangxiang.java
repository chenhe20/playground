import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 * 宇宙唯一张翔
 * singleton implemented with static
 */
public class Zhangxiang {

    public int age = 23;
    private static Zhangxiang instance = null;

    private Zhangxiang() {}

    static {
        instance = new Zhangxiang();
    }

    public static Zhangxiang getInstance() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("为您介绍宇宙唯一dsg张翔");
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(change(new Entity()).aNum);
        Thread thread = new Thread(() -> {});
        thread.start();
    }

    public static Entity change(Entity e) {
        //e = new Entity();
        e.aNum = 13;
        return e;
    }

}
