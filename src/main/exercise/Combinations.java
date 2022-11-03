import java.util.*;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class Combinations {

    List result = new LinkedList<>();
    LinkedList vector = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {

        backtrack(n, k, 1);

        return result;
    }

    public void backtrack(int n, int k, int startIdx) {
        if (vector.size() == k) {
            result.add(new ArrayList<>(vector));
            return;
        } else
            for (int i = startIdx; i <= n - (k - vector.size()) + 1; i++) {
                vector.add(i);
                backtrack(n, k, i + 1);
                vector.removeLast();
            }
        }

    public static void main(String[] args) {
        new Combinations().combine(4, 2);
    }
    }

