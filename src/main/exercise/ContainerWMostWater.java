/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class ContainerWMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;

        while (right -1 >= left) {
            max = Math.max((right-left) * Math.min(height[left], height[right]), max);
            // Move the pointer at the shorter line inwards
            if (height[left] < height[right]) {
                ++ left;
            } else {
                -- right;
            }
        }

        return max;

    }

    public static double sol(int n) {
        return Math.pow(0.6, n+2) * Math.pow(0.4, n) * Math.pow(2, n);
    }

    public static void main(String[] args) {
        double res = 0;


        for (int i = 0; i < 1020; i++) {
            res += sol(i);
        }

        System.out.println(res);
        System.out.println(sol(2));

    }
}
