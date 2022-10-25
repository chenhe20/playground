import java.util.*;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 * <p>
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /**
         * construct from 1 to target
         * t(n) = {...}
         * t(N) = m + t(n-m)
         *
         * 2 3 6 7 > 7
         * 1 null
         * 2 {{2}}
         * 3 {{3}}
         * 4 {{2,2}}
         * 5 {{2,3}}
         * 6 {{6}, {2,2,2},{3,3}}
         * 7 {{7}, {2,2,3}} duplicated
         *
         * keep an asc order avoiding duplication
         */

        List<List<Integer>> res = new ArrayList();
        HashMap<Integer, List<List<Integer>>> map = new HashMap();
        Arrays.sort(candidates);

        for (int i = 1; i <= target; i++) {
            List<List<Integer>> arr = new ArrayList();
            for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                if (i == candidates[j]) {
                    arr.add(Arrays.asList(i));
                } else {
                    List<List<Integer>> lists = map.get(i - candidates[j]);
                    for (List lst: lists) {
                        if (candidates[j] <= (int)lst.get(0)) {
                            ArrayList tmp = new ArrayList();
                            tmp.add(candidates[j]);
                            tmp.addAll(lst);
                            arr.add(tmp);
                        }
                    }

                }
            }
            map.put(i, arr);

            if (i == target) {
                res = map.get(i);
            }
        }
            return res;
        }
}
