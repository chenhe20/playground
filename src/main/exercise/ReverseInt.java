/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class ReverseInt {
    public int reverse(int x) {

        String s = String.valueOf(x);

        int absoluteX = x>0 ? x : -x;

        int scale = (int)(Math.log(absoluteX) / Math.log(10));
        int res = 0;

        for (int i = s.length()-1; i >=0 ; i--) {

            // Deal with negative symbol
            if (s.substring(i, i+1).equals("-")) {
                res = res * -1;
                break;
            }

            res += Integer.valueOf(s.substring(i,i+1)) * Math.pow(10, scale--);
        }

       if (res > Math.pow(2, 31) - 1 || res < -Math.pow(2, 31)) {
           return 0;
       }
        return res;
    }

    public static void main(String[] args) {
       new ReverseInt().reverse(-123);
    }
}
