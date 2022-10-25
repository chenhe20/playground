import java.lang.reflect.Array;
import java.util.*;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class ItrrTest {


    public static void main(String[] args) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        hp.put(1,1);
        hp.put(2,1);
        hp.put(3,1);
        hp.put(1,3);

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        Iterator<Map.Entry<Integer, Integer>> iterator = hp.entrySet().iterator();
        //list.remove(1);
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, Integer> next = iterator.next();
//            System.out.println(next.getKey() + " value "+next.getValue());
//            //iterator.remove();
//        }

//        hp.forEach((k,v) -> {
//            System.out.println(v);
//            hp.remove(k);
//        });
        list.forEach(System.out::println);
        list.forEach(x -> x = x+2);


    }

}
