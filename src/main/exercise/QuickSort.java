import java.util.ArrayList;
import java.util.List;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class QuickSort {
    public ArrayList<Integer> quickSort(List<Integer> arr) {

        ArrayList<Integer> less = new ArrayList<Integer>();
        ArrayList<Integer> more = new ArrayList<Integer>();
        ArrayList<Integer> pivot = new ArrayList<Integer>();


        if (arr.size() < 2) {
            return new ArrayList<>(arr);
        }

        for (int num:arr) {
            if (num < arr.get(0)) {
                less.add(num);
            } else if (num > arr.get(0)) {
                more.add(num);
            } else {
                pivot.add(num);
            }

        }
            less = quickSort(less);
            more = quickSort(more);
            less.addAll(pivot);
            less.addAll(more);
            return less;

        }
}
