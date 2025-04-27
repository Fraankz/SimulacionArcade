package arcade.controller;

import arcade.model.nqueens.NQueensGame;
import arcade.view.NQueensView;

import javax.swing.*;
import java.awt.*;

public class NQueensController {
    private NQueensView view;
    private NQueensGame game;

    public NQueensController(NQueensView view, NQueensGame game) {
        this.view = view;
        this.game = game;
        initController();
    }

    private void initController() {
        view.getSolveButton().addActionListener(e -> onSolveClicked());
    }

    private void onSolveClicked() {
        try {
            int n = Integer.parseInt(view.getNInputField().getText());
            if (n < 4) {
                JOptionPane.showMessageDialog(null, "Por favor ingresa un número mayor o igual a 4.");
                return;
            }

            game.initialize(n);

            boolean solved = game.solve();
            if (solved) {
                drawBoard(game.getBoard());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró solución.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido.");
        }
    }

    private void drawBoard(int[][] board) {
        JPanel boardPanel = view.getBoardPanel();
        boardPanel.removeAll(); // Limpiar anterior

        int size = board.length;
        boardPanel.setLayout(new GridLayout(size, size));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JLabel cell = new JLabel();
                cell.setHorizontalAlignment(JLabel.CENTER);
                cell.setVerticalAlignment(JLabel.CENTER);
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                if (board[i][j] == 1) {
                    cell.setText("♛"); // Reina
                }

                boardPanel.add(cell);
            }
        }

        boardPanel.revalidate();
        boardPanel.repaint();
    }
}
