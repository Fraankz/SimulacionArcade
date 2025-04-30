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

        view.getMoveAtoB().addActionListener(e -> makeMove('A', 'B'));
        view.getMoveAtoC().addActionListener(e -> makeMove('A', 'C'));
        view.getMoveBtoA().addActionListener(e -> makeMove('B', 'A'));
        view.getMoveBtoC().addActionListener(e -> makeMove('B', 'C'));
        view.getMoveCtoA().addActionListener(e -> makeMove('C', 'A'));
        view.getMoveCtoB().addActionListener(e -> makeMove('C', 'B'));
    }

    private void resetGame() {
        try {
            int disks = Integer.parseInt(view.getDiskField().getText());
            if (disks < 1 || disks > 8) throw new NumberFormatException();

            game.reset(disks);
            view.getOutputArea().setText("Juego reiniciado con " + disks + " discos.\n\n" + game.getState());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view.getFrame(), "Introduce un número entre 1 y 8.");
        }
    }

    private void makeMove(char from, char to) {
        if (game.move(from, to)) {
            view.getOutputArea().setText(game.getState());
        } else {
            JOptionPane.showMessageDialog(view.getFrame(), "Movimiento inválido. Recuerda: no puedes colocar un disco más grande sobre uno más pequeño.");
        }
    }
}
