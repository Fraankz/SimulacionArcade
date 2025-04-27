package arcade.model.nqueens;

import arcade.model.game.Game;

public class NQueensGame implements Game {
    private int[][] board;
    private int size;

    public NQueensGame() {
    }

    public void initialize(int n) {
        size = n;
        board = new int[n][n];
    }

    @Override
    public void initialize() {
        // No usado directamente aquí
    }

    @Override
    public boolean solve() {
        NQueensSolver solver = new NQueensSolver();
        return solver.solve(board, 0, size);
    }

    @Override
    public void reset() {
        initialize(size);
    }

    public int[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }
}
