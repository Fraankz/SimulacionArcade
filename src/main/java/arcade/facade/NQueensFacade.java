package arcade.facade;

import arcade.model.nqueens.NQueensGame;

public class NQueensFacade {
    private NQueensGame game;

    public NQueensFacade() {
        game = new NQueensGame();
    }

    public boolean solveNQueens() {
        return game.solve();
    }
}
