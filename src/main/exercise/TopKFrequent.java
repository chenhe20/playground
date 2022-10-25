import java.util.*;
import java.util.stream.Collectors;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            return  nums;
        }

        List<List<Integer>> bucket = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            bucket.add(new ArrayList());
        }

        Map<Integer, Integer> map = new HashMap();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int freq = entry.getValue();
                bucket.get(freq - 1).add(entry.getKey());
        }

        List<Integer> resLst = bucket.stream().flatMap(List::stream).
                collect(Collectors.toList());


        int[] res = new int[k];
        for (int m = 0; m < k; m++) {
            res[m] = resLst.get(resLst.size() - m - 1);
        }

        return res;
    }

}
