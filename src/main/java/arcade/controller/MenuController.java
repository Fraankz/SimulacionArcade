package arcade.controller;

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
        // Asignar acciones a cada botón
        menuView.getNQueensButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onNQueensSelected();
            }
        });

        menuView.getKnightTourButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onKnightTourSelected();
            }
        });

        menuView.getHanoiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onHanoiSelected();
            }
        });
    }

    private void onNQueensSelected() {
        JOptionPane.showMessageDialog(null, "Has seleccionado el Problema de N Reinas");
        // Aquí luego se llamará a GameFactory para lanzar el juego
    }

    private void onKnightTourSelected() {
        JOptionPane.showMessageDialog(null, "Has seleccionado el Recorrido del Caballo");
    }

    private void onHanoiSelected() {
        JOptionPane.showMessageDialog(null, "Has seleccionado las Torres de Hanói");
    }
}
