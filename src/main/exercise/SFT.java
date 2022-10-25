/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class SFT {
    public int sft(int x, int y) {
        while (x < y) {
            x += 1;
            if (x%5 <= 2) {
                y = 2*y;
            }

        }
        x = 2*y;
        return x;
    }
}
