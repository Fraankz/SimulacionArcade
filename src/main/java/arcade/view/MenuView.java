package arcade.view;

import javax.swing.*;
import java.awt.*;

public class MenuView {
    private JFrame frame;
    private JButton nQueensButton;
    private JButton knightTourButton;
    private JButton hanoiButton;

    public void showMenu() {
        frame = new JFrame("Arcade de Lógica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Centrar ventana

        // Crear botones
        nQueensButton = new JButton("Problema de N Reinas");
        knightTourButton = new JButton("Recorrido del Caballo");
        hanoiButton = new JButton("Torres de Hanói");

        // Panel de botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 filas, 1 columna, espacio de 10px
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50)); // márgenes alrededor

        panel.add(nQueensButton);
        panel.add(knightTourButton);
        panel.add(hanoiButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Métodos para que el controlador pueda acceder a los botones
    public JButton getNQueensButton() {
        return nQueensButton;
    }

    public JButton getKnightTourButton() {
        return knightTourButton;
    }

    public JButton getHanoiButton() {
        return hanoiButton;
    }
}
