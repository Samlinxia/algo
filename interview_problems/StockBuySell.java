import java.util.*;

public class StockBuySell {
  private static BitSet[] rowSet = new BitSet[9];
  private static BitSet[] colSet = new BitSet[9];
  private static BitSet[] blockSet = new BitSet[9];
  public static void solveSudoku(char[][] board) {
      if (board == null || board.length != 9 || board[0].length != 9) {
          return;
      }
      init(board);
      helper(board, 0, 0);
  }
  
  private static boolean helper(char[][] board, int row, int col) {
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
              board[i][j] = '.';
              return false;
          }
      }
      return true;
  }
  
  private static boolean isValid(int row, int col, int val) {
      if (rowSet[row].get(val) || colSet[col].get(val)
              || blockSet[row / 3 * 3 + col / 3].get(val)) {
                  return false;
              }
      return true;
  }
  
  private static void updateSet(int row, int col, int val, boolean flag) {
      rowSet[row].set(val, flag);
      colSet[col].set(val, flag);
      blockSet[row / 3 * 3 + col / 3].set(val, flag);
  }
  
  private static void init(char[][] board) {
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

  public static void main(String[] args) {
	 String[] input = new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
	 char[][] board = new char[9][9];
	 for (int j = 0; j < 9; j++) { 
		for (int i = 0; i < 9; i++) {
		  board[j][i] = input[j].charAt(i);
		}
	 }
	 solveSudoku(board);
	 for (int j = 0; j < 9; j++) { 
		for (int i = 0; i < 9; i++) {
		  System.out.print(board[j][i]);
		}
		System.out.println(",");
	 }
  }
}
