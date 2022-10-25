import java.util.HashSet;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class PredictWinner {
    class Pair {
        int first;
        int second;

    }

    public boolean PredictTheWinner(int[] nums) {

        Pair[][] pairs = new Pair[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                pairs[i][j] = new Pair();

                if (i == j) {
                    pairs[i][j].first = nums[i];
                    pairs[i][j].second = 0;
                }
            }
        }

        // dp

        for (int i = nums.length - 2; i >= 0; i --) {
            for (int j = i + 1; j< nums.length; j++) {

                int left = pairs[i+1][j].second + nums[i];
                int right = pairs[i][j-1].second + nums[j];

                if (left > right) {
                    pairs[i][j].first = left;
                    pairs[i][j].second = pairs[i+1][j].first;
                } else {
                    pairs[i][j].first = right;
                    pairs[i][j].second = pairs[i][j-1].first;
                }
            }
        }

        Pair res = pairs[0][nums.length-1];
        return res.first >= res.second;


    }

    public static void main(String[] args) {
        PredictWinner predictWinner = new PredictWinner();
        predictWinner.PredictTheWinner(new int[]{1,5,2});

        char[] b =  new String("sd").toCharArray();

        HashSet integers = new HashSet<Integer>();
    }
}
