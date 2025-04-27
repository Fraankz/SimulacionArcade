package arcade.facade;

import arcade.model.hanoi.HanoiGame;

public class HanoiFacade {
    private HanoiGame game;

    public HanoiFacade() {
        game = new HanoiGame();
    }

    public boolean solveHanoi() {
        return game.solve();
    }
}
