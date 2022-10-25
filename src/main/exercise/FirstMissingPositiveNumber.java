/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 */
public class FirstMissingPositiveNumber {
    public int firstMissingPositive(int[] nums) {

        int res = 0;

        int[] labelList = new int[nums.length];
        for (int label:labelList) {
            label = 0;
        }

        for (int num:nums) {
            if (num <= 0 || num > nums.length) {
                continue;
            } else {
                labelList[num-1] = 1;
            }
        }



        for (int i = 0; i < labelList.length; i++) {
            if (labelList[i] == 0) {
                res = i + 1;
                break;
            }
        }

        if (res == 0) {
            res = nums.length + 1;
        }
        return res;
    }
}
