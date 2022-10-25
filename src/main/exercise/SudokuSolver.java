import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 */
public class SudokuSolver {

    // store the potential value for each location that has not been decided the value
    // the key stores the location info and the value stores possible values
    //HashMap pValue = new HashMap<ArrayList<Integer>, ArrayList<Character>>();


    public void solveSudoku(char[][] board) {


        char[][][] potentialValue = new char[9][9][9];

        // loop until solve the sudoku
        boolean find_new = true;


        while (find_new){
            find_new = false;
            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board[row].length; column++) {
                    // if the value has not benn decided,
                    // then update its potential value
                    if (board[row][column] == '.') {
                        // stores the value that has been used in that row, column and sub-board
                        Set<Integer> takenValue = new HashSet<>();
                        // check the potential value of other node in the same row, column and sub-board
                        //Set<Character> potentialTakenValue = new HashSet<>();

                        // by the row
                        for (int col_index = 0; col_index < 9; col_index++) {
                            if (col_index != column) {
                                if (board[row][col_index] != '.') {
                                    takenValue.add(Integer.parseInt(String.valueOf(board[row][col_index])));
                                }
                            }
                        }


                        if (takenValue.size() == 8) {
                            for (int i = 1; i < 10; i++) {
                                if (!takenValue.contains(i)){
                                    board[row][column] = Integer.toString(i).charAt(0);
                                }
                            }
                            find_new = true;
                            continue;
                        }

                        // by the column
                        for (int row_index = 0; row_index < 9; row_index++) {
                            if (row_index != row) {
                                if (board[row_index][column] != '.') {
                                    takenValue.add(Integer.parseInt(String.valueOf(board[row_index][column])));
                                }
                            }
                        }

                        if (takenValue.size() == 8) {
                            for (int i = 1; i < 10; i++) {
                                if (!takenValue.contains(i)) {
                                    board[row][column] = Integer.toString(i).charAt(0);
                                }
                            }
                            find_new = true;
                            continue;
                        }

                        // by the sub-board
                        for (int row_incre = 0; row_incre < 3; row_incre++) {
                            for (int col_incre = 0; col_incre < 3; col_incre++) {
                                if ((int)(row/3)*3+row_incre == row && (int)(column/3)*3+col_incre == column) {
                                    continue;
                                } else {
                                    if (board[(int)(row/3)*3+row_incre][(int)(column/3)*3+col_incre] != '.') {
                                        takenValue.add(Integer.parseInt(String.valueOf(board[(int)(row/3)*3+row_incre][(int)(column/3)*3+col_incre])));
                                    }
                                }

                            }
                        }

                        if (takenValue.size() == 8) {
                            for (int i = 1; i < 10; i++) {
                                if (!takenValue.contains(i)) {
                                    board[row][column] = Integer.toString(i).charAt(0);
                                }
                            }
                            find_new = true;
                            continue;
                        } else {

                        }


                    }
                }
            }
        }


    }


}
