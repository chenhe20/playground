/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class TrapRainWater {

    public int trap(int[] height) {

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        int max = 0;
        for (int i = 0; i < height.length; i++) {

            if (i == 0) {
                maxLeft[i] = 0;
                max = height[i];
            } else {
                if (height[i-1] > max) {
                    maxLeft[i] = height[i-1];
                    max = height[i-1];
                } else {
                    maxLeft[i] = max;
                }
            }
        }

        max = 0;
        for (int i = height.length - 1; i > 0; i--) {

            if (i == height.length - 1) {
                maxRight[height.length - 1] = 0;
                max = height[i];
            } else {
                if (height[i+1] > max) {
                    maxRight[i] = height[i+1];
                    max = height[i+1];
                } else {
                    maxRight[i] = max;
                }
            }
        }

        int area = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] < maxLeft[i] && height[i] < maxRight[i]) {
                area += Math.min(maxLeft[i], maxRight[i]) - height[i];
            }
        }

        return area;
    }
}
