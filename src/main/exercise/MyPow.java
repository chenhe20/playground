/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 *
 * Implement pow(x, n),
 * which calculates x raised to the power n (i.e., xn).
 */
public class MyPow {
    public double myPow(double x, int n) {

        if (x == 0)
            return 0.0;

        if (n == 0)
            return 1.0;

        if (n > 0) {
            double res = 1.0;
            for (int i = 0; i < n; i++) {
                res = res * x;
            }
            return res;
        }

        // else if n < 0
        else {
            double res = 1.0;
            x = 1/x;
            for (int i = 0; i < -1 * n; i++) {
                res = res * x;
            }
            return res;
        }
    }
}
