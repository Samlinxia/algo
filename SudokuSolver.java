/**
    make clear: 
        1.if there is always exist a solution, or no solution could also be possible?
        "You may assume that there will be only one unique solution." -> early return once find a solution
*/
import java.util.BitSet;

public class Solution {
    private BitSet[] rowSet = new BitSet[9];
    private BitSet[] colSet = new BitSet[9];
    private BitSet[] blockSet = new BitSet[9];
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        init(board);
        helper(board, 0, 0);
    }
    
    private boolean helper(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }
        
        for (int i = row; i < 9; i++) {
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (int v = 1; v <= 9; v++) {
                    if (!isValid(i, j, v)) {
                        continue;
                    }
                    //update
                    board[i][j] = (char) ('0' + v);
                    updateSet(i, j, v, true);
                    boolean res;
                    if (j < 8) {
                        res = helper(board, i, j + 1);
                    } else {
                        res = helper(board, i + 1, 0);
                    }
                    if (res) {
                        return true;
                    }
                    updateSet(i, j, v, false);
                }
				//backtracking
                board[i][j] = '.';
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(int row, int col, int val) {
        if (rowSet[row].get(val) || colSet[col].get(val)
                || blockSet[row / 3 * 3 + col / 3].get(val)) {
                    return false;
                }
        return true;
    }
    
    private void updateSet(int row, int col, int val, boolean flag) {
        rowSet[row].set(val, flag);
        colSet[col].set(val, flag);
        blockSet[row / 3 * 3 + col / 3].set(val, flag);
    }
    
    private void init(char[][] board) {
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new BitSet(10);
            colSet[i] = new BitSet(10);
            blockSet[i] = new BitSet(10);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int x = board[i][j] - '0';
                updateSet(i, j, x, true);
            }
        }
    }
}