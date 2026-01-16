package leetcode;

import java.util.Arrays;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
        };
        isValidSudoku(board);
    }

    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            System.out.println(new String(board[i]));
            int[] row = new String(board[i]).chars().map(c->c == '.' ? 0 : c - '0').toArray();
        }
        return false;
    }
}
