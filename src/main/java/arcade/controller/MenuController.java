package arcade.controller;

import arcade.factory.GameFactory;
import arcade.model.game.Game;
import arcade.view.MenuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
    private MenuView menuView;

    public MenuController(MenuView menuView) {
        this.menuView = menuView;
        initController();
    }

    private void initController() {
        menuView.getNQueensButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onGameSelected("nqueens");
            }
        });

        menuView.getKnightTourButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onGameSelected("knighttour");
            }
        });

        menuView.getHanoiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onGameSelected("hanoi");
            }
        });
    }

    private void onGameSelected(String gameType) {
        try {
            Game game = GameFactory.createGame(gameType);

            switch (gameType) {
                case "nqueens":
                    arcade.model.nqueens.NQueensGame nQueensGame = (arcade.model.nqueens.NQueensGame) game;
                    arcade.view.NQueensView nQueensView = new arcade.view.NQueensView();
                    new arcade.controller.NQueensController(nQueensView, nQueensGame);
                    nQueensView.show();
                    break;
                case "knighttour":
                    JOptionPane.showMessageDialog(null, "Knight's Tour aún no implementado.");
                    break;
                case "hanoi":
                    JOptionPane.showMessageDialog(null, "Torres de Hanoi aún no implementado.");
                    break;
            }

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear el juego: " + ex.getMessage());
        }
    }


}
