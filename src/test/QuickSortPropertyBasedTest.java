import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class QuickSortPropertyBasedTest {

    public List<Integer> testArr = new ArrayList<>();

    @Before
    public void init() {
        testArr = Stream.of(1,3,5,4,2).collect(Collectors.toCollection(ArrayList::new));
        System.out.print("start");
    }

    @Test
    public void isSorted() {
        QuickSort quickSort = new QuickSort();
        Assert.assertEquals(quickSort.quickSort(testArr),new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)));

    }

    //@Property
    public boolean tailGreaterOrEqualThanHead(@ForAll List<Integer> arr) {

//        ArrayList<Integer> arr = new ArrayList<>();
//        for (int num:toCollectArr
//             ) {
//            arr.add(num);
//        }
        if (arr.isEmpty()) {
            return true;
        } else {
            QuickSort quickSort = new QuickSort();
            ArrayList<Integer> sortedArr = quickSort.quickSort(arr);
            int head = sortedArr.get(0);
            int tail = sortedArr.get(sortedArr.size()-1);
            return head <= tail;
        }

    }
}
