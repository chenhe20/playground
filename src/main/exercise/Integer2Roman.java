/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class Integer2Roman {
    public String intToRoman(int num) {

        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] pattern = {"M", ""};
        StringBuilder res = new StringBuilder();

        // 1000 M count

        int mCount = num / 1000;

        for (int i = 0; i < mCount; i++) {
            res.append("M");
        }

        num -= mCount*1000;

        return res.toString();
    }
}
