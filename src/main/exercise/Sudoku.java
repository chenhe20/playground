import java.util.Arrays;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class Sudoku {
    public void solveSudoku(char[][] board) {
        solve(0, 0, board);
    }

    public boolean solve(int row, int col, char[][] board) {
        if (row ==8 && col == 8) {
            return true;
        }

        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (test(row, col, i, board)) {
                    board[row][col] = (char) (i + '0');

                    // backtrack
                    if (col == 8) {
                        if (solve(row+1, 0, board) == true) return true;
                    }
                    else {
                        if(solve(row, col+1, board) == true) return true;
                    }

                    board[row][col] = '.';
                }
            }

            return false;
        } else {
            if (col == 8) {
                return solve(row+1, 0, board);
            }
            else {
                return solve(row, col+1, board);
            }
        }
    }

    boolean test (int row, int col, int val, char[][] board) {
        //row, column, diagonal, block

        // row distinction
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == (char) (val + '0') && i != col) return false;
        }

        // column distinction
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == (char) (val + '0') && i != row) return false;
        }

        // block distinction
        for (int r = (row/3) * 3, n = 0; n < 3; r++, n++) {
            for (int c = (col/3) * 3, nn = 0; nn < 3; c++, nn++) {
                if (board[r][c] == (char) (val + '0')) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        String s = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
//        s = s.replace("]", "}").replace("[", "{").replace("\"", "\'");
//        System.out.println(s);

        char[][] c = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new Sudoku().solveSudoku(c);
        Arrays.stream(c).forEach(System.out::println);
    }
}
