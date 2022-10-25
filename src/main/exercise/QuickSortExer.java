import java.util.Arrays;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class QuickSortExer {

public void quickSort(int[] nums) {
    quickSort(nums, 0, nums.length-1);
    }

    void quickSort(int[] nums, int start, int end) {

        if (start == end || start < 0 || start > end) return;

        int pivot = nums[start];
        int leftPtr = start + 1;
        int rightPtr = end;

        while (leftPtr != rightPtr) {
            if (nums[leftPtr] > pivot) {
                if (nums[rightPtr] <= pivot) {
                    int temp = nums[rightPtr];
                    nums[rightPtr] = nums[leftPtr];
                    nums[leftPtr] = temp;
                } else {
                    rightPtr --;
                    continue;
                }
            } else {
                leftPtr ++;
            }
        }

        if (nums[leftPtr] >= pivot) {
            nums[start] = nums[leftPtr-1];
            nums[leftPtr-1] = pivot;

            quickSort(nums, 0, leftPtr-2);
            quickSort(nums, leftPtr, end);

        } else {
            nums[start] = nums[leftPtr];
            nums[leftPtr] = pivot;

            quickSort(nums, 0, leftPtr-1);
            quickSort(nums, leftPtr+1, end);
        }

    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        QuickSortExer quickSortExer = new QuickSortExer();
        quickSortExer.quickSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    /**  [5, 3]
     *  cons(head(L), cons(head(tail(L)), tail(tail(tail(L)))))
     */
}

