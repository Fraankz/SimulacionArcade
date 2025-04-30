package arcade.model.knighttour;

public class KnightTourSolver {
    private final int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public boolean solve(int[][] board, int x, int y, int move) {
        int size = board.length;
        if (move == size * size) return true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < size && ny < size && board[nx][ny] == -1) {
                board[nx][ny] = move;
                if (solve(board, nx, ny, move + 1)) return true;
                board[nx][ny] = -1;
            }
        }
        return false;
    }

    public int[][] generateSolution(int size, int startX, int startY) {
        int[][] board = new int[size][size];
        for (int[] row : board)
            java.util.Arrays.fill(row, -1);
        board[startX][startY] = 0;
        if (!solve(board, startX, startY, 1)) return null;
        return board;
    }
}
