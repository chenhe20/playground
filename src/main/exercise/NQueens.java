import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class NQueens {
    List<List<String>> ans = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {

        helper(0, n, new  LinkedList<>());

        return ans;
    }

    void helper(int row, int n, LinkedList<String> sol) {
        if (row == n) {
         ans.add(new LinkedList<>(sol));
         return;
        }

        // Test if the ith column at this row is available to place Q
        for (int i = 0; i < n; i++) {
            if (testAllCol(i, sol, row) && testAllDiag(i, sol, row, n)) {
                sol.add(constructS(n, i));
                helper(row+1, n, sol);
                sol.removeLast();
            }
        }
    }

    boolean testAllCol(int col,  LinkedList<String> sol, int row) {

        for (int i = 0; i < row; i++) {
            String s = sol.get(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'Q' && j == col) return false;
            }
        }

        return true;
    }

    boolean testAllDiag(int col,  LinkedList<String> sol, int row, int n) {

        for (int colLeft = col-1, colRight = col+1, r = row-1 ; r >= 0 ; colLeft--, colRight++, r --) {
            String s = sol.get(r);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'Q') {
                    if (i == colLeft || i == colRight) return false;
                }
            }
        }

        return true;
    }

    String constructS(int n, int col) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == col) sb.append("Q");
            else sb.append(".");
        }
        return sb.toString();
    }
}
