import java.util.Stack;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 * Monotonic ascend stack
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < temperatures.length; i++) {
            if (i == 0) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer index = stack.pop();
                res[index] = i - index;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }

        return res;
    }
}
