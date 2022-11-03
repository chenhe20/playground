/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class Integer2Roman {
    public String intToRoman(int num) {

        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] pattern = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();

        int i = 0;
        while (i < value.length) {
            if (num - value[i] >= 0) {
                num -= value[i];
                res.append(pattern[i]);
            } else {
                ++ i;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        new Integer2Roman().intToRoman(3);
    }
}
