package arcade.model.nqueens;

public class NQueensSolver {

    public boolean solve(int[][] board, int col, int n) {
        if (col >= n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1;

                if (solve(board, col + 1, n)) {
                    return true;
                }

                board[i][col] = 0; // backtrack
            }
        }

        return false;
    }

    private boolean isSafe(int[][] board, int row, int col, int n) {
        // Fila izquierda
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Diagonal superior izquierda
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Diagonal inferior izquierda
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
