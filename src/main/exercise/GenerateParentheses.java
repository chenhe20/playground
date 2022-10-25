import java.util.ArrayList;
import java.util.List;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 *
 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParentheses {

    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {

        String str = "(";

        int left = 2*n - 1;
        int open = 1;
        int close = 0;
        // open + close + left = n
        append(str, open, left, close);

        return res;
    }

    public void append(String str, int open, int left, int close) {
        // no more to add
        if (left == 0) {
            res.add(str);
            return;
        }

        // can not add more ) currently
        if (close == open && left != 0 ) {
            append(str+"(", open + 1, left - 1, close);
            return;
        }

        // must close now
        if (open - close == left) {
            append(str+")", open, left - 1, close + 1);
            return;
        }

        // else free to add anything

        append(str+"(", open + 1, left - 1, close);
        append(str+")", open, left - 1, close + 1);
        return;

    }

}
