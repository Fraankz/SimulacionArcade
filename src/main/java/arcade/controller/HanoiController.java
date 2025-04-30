package arcade.controller;

import arcade.model.hanoi.HanoiGame;
import arcade.view.HanoiView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class HanoiController {
    private final HanoiView view;
    private final HanoiGame game;
    private final DragManager dragManager;

    public HanoiController(HanoiView view, HanoiGame game) {
        this.view = view;
        this.game = game;
        this.dragManager = new DragManager(view, game);

        initController();
    }

    private void initController() {
        view.getResetButton().addActionListener(e -> resetGame());
        resetGame();
    }

    private void resetGame() {
        try {
            int disks = Integer.parseInt(view.getDiskField().getText());
            if (disks < 1 || disks > 8) throw new NumberFormatException();

            game.reset(disks);
            dragManager.renderTowers();
            view.updateMoveCount(game.getMoveCount());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view.getFrame(), "Introduce un número entre 1 y 8.");
        }
    }
}
