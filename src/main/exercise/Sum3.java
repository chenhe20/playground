import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class Sum3 {
    public static List<List<Integer>> solution(int[] nums) {

        List result = new ArrayList<ArrayList<Integer>>();

        // invalid input
        if (nums.length <= 2 || nums.equals(null)) {
            return result;
        }

        // sort the array in an ascending order
        Arrays.sort(nums);


        for (int i = 0; i < nums.length ; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; // avoid duplicated result
            // init two pointers
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // if the next pointer is as same as the last one,
                    // there is no reason to calculate the sum again
                    while (nums[left] == nums[left + 1] && left + 1 < right) left ++;
                    while (nums[right] == nums[right - 1] && right - 1 > left) right --;
                    left ++;
                    right --;
                } else if (sum < 0) {
                    left ++;
                } else {
                    right --;
                }
            }
        }

        return result;
    }
}
