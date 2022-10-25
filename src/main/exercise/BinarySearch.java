/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class BinarySearch {
    static int[] a;

    public int search(int[] nums, int target) {
        int headIdx = 0;
        int tailIdx = nums.length-1;

        if(target == nums[headIdx]) {
            return headIdx;
        }

        if (target == nums[tailIdx]) {
            return tailIdx;
        }

        if (target < nums[headIdx] || target > nums[tailIdx]) {
            return -1;
        }


        return binSearch(nums, headIdx, tailIdx, target);

    }

    public int binSearch(int[] nums, int headIdx, int tailIdx, int target) {

        // calculate the index of the middle number
        if (tailIdx - headIdx == 1) {
            return -1;// cannot be divided further
        }

        int midIdx = (tailIdx - headIdx)/2 + headIdx;

        // compare with the middle number
        if (target == nums[midIdx]) {
            return midIdx;
        }

        if (target < nums[midIdx]) {
            return binSearch(nums, headIdx, midIdx, target);
        }

        if (target > nums[midIdx]) {
            return binSearch(nums, midIdx, tailIdx, target);
        }

        return -1;
    }

    public static void main(String[] args) {


        System.out.println();


        // 6
        // 7
        // 10
        // 10
    }
}
