package arcade.controller;

import arcade.model.nqueens.NQueensGame;
import arcade.view.NQueensView;

import javax.swing.*;

public class NQueensController {
    private final NQueensView view;
    private final NQueensGame game;

    public NQueensController(NQueensView view, NQueensGame game) {
        this.view = view;
        this.game = game;
        initController();
    }

    private void initController() {
        view.getSolveButton().addActionListener(e -> solveNQueens());
    }

    private void solveNQueens() {
        try {
            int n = Integer.parseInt(view.getNInputField().getText());
            if (n <= 0) throw new NumberFormatException();

            int[][] board = game.solve(n);  // se delega al modelo
            if (board != null) {
                view.getBoardPanel().setBoard(board);
            } else {
                JOptionPane.showMessageDialog(view.getFrame(), "No se encontró solución para N = " + n);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view.getFrame(), "Introduce un número válido mayor que 0");
        }
    }
}
