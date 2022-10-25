import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 *
 * Given an array nums of distinct integers,
 * return all the possible permutations. You can return the answer in any order.
 *
 *
 * 123
 *
 * 1  2  3
 *
 * 12 13    21 23    31 32
 *
 * 123 132  213 231 312 321
 */
public class permutation {

    public List<List<Integer>> permute(int[] nums) {
        List res = new ArrayList();

        recurSol(new ArrayList(), new boolean[nums.length], res, nums);

        return res;
    }

    public void recurSol(List currRes, boolean[] used, List res, int[] nums) {

        if (currRes.size() == nums.length) {
            res.add(currRes);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            used[i] = true;
            List tempRes = new ArrayList(currRes);
            tempRes.add(nums[i]);
            recurSol(tempRes, used, res, nums);
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        permutation permutation = new permutation();
        List<List<Integer>> permute = permutation.permute(new int[]{1, 2, 3});

        permute.forEach(System.out::println);

    }
}
