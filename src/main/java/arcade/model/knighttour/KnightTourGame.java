package arcade.model.knighttour;

import arcade.model.game.Game;

public class KnightTourGame implements Game {
    private KnightTourSolver solver;
    private int[][] board;

    public KnightTourGame() {
        solver = new KnightTourSolver();
    }

    public boolean solve(int size, int startX, int startY) {
        board = solver.generateSolution(size, startX, startY);
        return board != null;
    }

    public int[][] getBoard() {
        return board;
    }

    @Override
    public void initialize() {
        // No usado en esta versión
    }

    @Override
    public boolean solve() {
        return false; // No usado
    }

    @Override
    public void reset() {
        board = null;
    }
}
