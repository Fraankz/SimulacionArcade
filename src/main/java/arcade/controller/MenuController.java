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
            JOptionPane.showMessageDialog(null, "Juego creado: " + game.getClass().getSimpleName());
            // Luego abriríamos la vista correspondiente aquí
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear el juego: " + ex.getMessage());
        }
    }
}
