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
            switch (gameType) {
                case "nqueens":
                    arcade.model.nqueens.NQueensGame nQueensGame = new arcade.model.nqueens.NQueensGame();
                    arcade.view.NQueensView nQueensView = new arcade.view.NQueensView();
                    new arcade.controller.NQueensController(nQueensView, nQueensGame);
                    nQueensView.show();
                    break;
                case "knighttour":
                    arcade.model.knighttour.KnightTourGame knightGame = new arcade.model.knighttour.KnightTourGame();
                    arcade.view.KnightTourView knightView = new arcade.view.KnightTourView();
                    new arcade.controller.KnightTourController(knightView, knightGame);
                    knightView.show();
                    break;
                case "hanoi":
                    arcade.model.hanoi.HanoiGame hanoiGame = new arcade.model.hanoi.HanoiGame();
                    arcade.view.HanoiView hanoiView = new arcade.view.HanoiView();
                    new arcade.controller.HanoiController(hanoiView, hanoiGame);
                    hanoiView.show();
                    break;
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear el juego: " + ex.getMessage());
        }
    }



}
