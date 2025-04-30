package arcade.model.nqueens;

import arcade.model.game.Game;

public class NQueensGame implements Game{
    public int[][] solve(int n) {
        int[][] board = new int[n][n];
        if (solveRecursive(0, board, n)) {
            return board;
        }
        return null;
    }

    private boolean solveRecursive(int row, int[][] board, int n) {
        if (row == n) return true;

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 1;
                if (solveRecursive(row + 1, board, n)) return true;
                board[row][col] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(int row, int col, int[][] board, int n) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1) return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 1) return false;

        return true;
    }

    @Override
    public void initialize() {

    }

    @Override
    public boolean solve() {
        return false;
    }

    @Override
    public void reset() {

    }
}
