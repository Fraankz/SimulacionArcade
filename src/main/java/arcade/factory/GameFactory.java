package arcade.factory;

import arcade.model.game.Game;
import arcade.model.nqueens.NQueensGame;
import arcade.model.knighttour.KnightTourGame;
import arcade.model.hanoi.HanoiGame;

public class GameFactory {

    public static Game createGame(String gameType) {
        switch (gameType.toLowerCase()) {
            case "nqueens":
                return new NQueensGame();
            case "knighttour":
                return new KnightTourGame();
            case "hanoi":
                return new HanoiGame();
            default:
                throw new IllegalArgumentException("Tipo de juego desconocido: " + gameType);
        }
    }
}
