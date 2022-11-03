import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class ArrayReduction {

    static int minSize;

    public static int solution (List<Integer> arr) {

        boolean[] used = new boolean[arr.size()];
        minSize = arr.size();

        reduction(arr, used, arr.size(), 0);

        return minSize;
    }

    public static void reduction(List<Integer> arr, boolean[] used, int size, int usedSize) {

        if (minSize > size) minSize = size;

        if (arr.size() - usedSize < 2) {
            return;
        }

        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if (used[i] == false && used[j] == false) {
                    if (2 * arr.get(i) <= arr.get(j) || 2 * arr.get(j) <= arr.get(i)) {
                        used[i] = true;
                        used[j] = true;
                        reduction(arr, used, size - 1, usedSize + 2);
                        used[i] = false;
                        used[j] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println( solution(Arrays.asList(1,2,1,2,4)));

    }

}
