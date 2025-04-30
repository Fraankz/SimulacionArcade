package arcade.controller;

import arcade.model.hanoi.HanoiGame;
import arcade.view.HanoiView;

import javax.swing.*;

public class HanoiController {
    private final HanoiView view;
    private final HanoiGame game;

    public HanoiController(HanoiView view, HanoiGame game) {
        this.view = view;
        this.game = game;
        initController();
    }

    private void initController() {
        view.getResetButton().addActionListener(e -> resetGame());

        view.getMoveButtons()[0].addActionListener(e -> tryMove(0, 1)); // A→B
        view.getMoveButtons()[1].addActionListener(e -> tryMove(0, 2)); // A→C
        view.getMoveButtons()[2].addActionListener(e -> tryMove(1, 0)); // B→A
        view.getMoveButtons()[3].addActionListener(e -> tryMove(1, 2)); // B→C
        view.getMoveButtons()[4].addActionListener(e -> tryMove(2, 0)); // C→A
        view.getMoveButtons()[5].addActionListener(e -> tryMove(2, 1)); // C→B
    }

    private void resetGame() {
        try {
            int disks = Integer.parseInt(view.getDiskField().getText());
            if (disks < 1 || disks > 8) throw new NumberFormatException();

            game.reset(disks);
            view.updateTowers(game.getTowers(), game.getMoveCount(), false);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view.getFrame(), "Introduce un número de discos entre 1 y 8.");
        }
    }

    private void tryMove(int from, int to) {
        if (game.move(from, to)) {
            boolean win = game.isVictory();
            view.updateTowers(game.getTowers(), game.getMoveCount(), win);
            if (win) {
                JOptionPane.showMessageDialog(view.getFrame(), "¡Has ganado en " + game.getMoveCount() + " movimientos!");
            }
        } else {
            JOptionPane.showMessageDialog(view.getFrame(), "Movimiento inválido.");
        }
    }
}
