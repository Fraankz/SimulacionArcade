package arcade.controller;

import arcade.model.knighttour.KnightTourGame;
import arcade.view.KnightTourView;

import javax.swing.*;
import java.awt.*;

public class KnightTourController {
    private final KnightTourView view;
    private final KnightTourGame game;

    public KnightTourController(KnightTourView view, KnightTourGame game) {
        this.view = view;
        this.game = game;
        initController();
    }

    private void initController() {
        view.getSolveButton().addActionListener(e -> solveTour());
    }

    private void solveTour() {
        try {
            int size = Integer.parseInt(view.getBoardSizeField().getText());
            int startX = Integer.parseInt(view.getStartXField().getText());
            int startY = Integer.parseInt(view.getStartYField().getText());

            if (!game.solve(size, startX, startY)) {
                JOptionPane.showMessageDialog(view.getFrame(), "No se encontró solución");
                return;
            }

            int[][] board = game.getBoard();
            JPanel boardPanel = view.getBoardPanel();
            boardPanel.removeAll();
            boardPanel.setLayout(new GridLayout(size, size));

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    JLabel label = new JLabel(String.valueOf(board[i][j]), SwingConstants.CENTER);
                    label.setOpaque(true);
                    label.setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
                    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    boardPanel.add(label);
                }
            }

            boardPanel.revalidate();
            boardPanel.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view.getFrame(), "Parámetros inválidos");
        }
    }
}
