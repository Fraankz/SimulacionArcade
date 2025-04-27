package arcade.facade;

import arcade.model.knighttour.KnightTourGame;

public class KnightTourFacade {
    private KnightTourGame game;

    public KnightTourFacade() {
        game = new KnightTourGame();
    }

    public boolean solveKnightTour() {
        return game.solve();
    }
}
