package arcade.controller;

import arcade.model.hanoi.HanoiGame;
import arcade.view.HanoiView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HanoiController {
    private final HanoiView view;
    private final HanoiGame game;
    private int selectedTower = -1;

    public HanoiController(HanoiView view, HanoiGame game) {
        this.view = view;
        this.game = game;
        initController();
    }

    private void initController() {
        view.getResetButton().addActionListener(e -> resetGame());

        // Listeners para cada torre
        view.getTowerPanels()[0].addMouseListener(new TowerClickListener(0));
        view.getTowerPanels()[1].addMouseListener(new TowerClickListener(1));
        view.getTowerPanels()[2].addMouseListener(new TowerClickListener(2));

        resetGame();
    }

    private void resetGame() {
        try {
            int disks = Integer.parseInt(view.getDiskField().getText());
            if (disks < 1 || disks > 8) throw new NumberFormatException();

            game.reset(disks);
            selectedTower = -1;
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

    private class TowerClickListener extends MouseAdapter {
        private final int towerIndex;

        public TowerClickListener(int towerIndex) {
            this.towerIndex = towerIndex;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (selectedTower == -1) {
                selectedTower = towerIndex;
                view.highlightTower(towerIndex, true);
            } else {
                view.highlightTower(selectedTower, false);
                tryMove(selectedTower, towerIndex);
                selectedTower = -1;
            }
        }
    }
}
