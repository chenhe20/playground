import java.util.Stack;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class validParentheses {

    public boolean isValid(String s) {

        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            if (sub.equals("(") || sub.equals("{") || sub.equals("[")) {
                stack.push(sub);

            } else {

                if (stack.size() == 0) return false;
                else if (sub.equals(")")) {
                    if (!stack.pop().equals("(")) return false;
                } else if (sub.equals("}")) {
                    if (!stack.pop().equals("{")) return false;
                } else if (sub.equals("]")) {
                    if (!stack.pop().equals("[")) return false;
                }
            }
        }

        if (stack.size() != 0) return false;

        return true;
    }
}
