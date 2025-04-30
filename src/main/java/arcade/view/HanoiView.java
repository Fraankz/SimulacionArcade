package arcade.view;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class HanoiView {
    private final JFrame frame;
    private final JTextField diskField;
    private final JButton resetButton;

    private final JLayeredPane layeredPane;
    private final JPanel[] towerPanels;
    private final JLabel moveCounterLabel;

    public static final int PANEL_WIDTH = 800;
    public static final int PANEL_HEIGHT = 600;
    public static final int TOWER_WIDTH = 200;
    public static final int TOWER_HEIGHT = 400;

    public HanoiView() {
        frame = new JFrame("Torres de Hanoi - Drag & Drop");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        frame.setLayout(new BorderLayout());

        // Panel superior (entrada y reset)
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Número de discos (1–8):"));
        diskField = new JTextField(5);
        resetButton = new JButton("Reiniciar");
        topPanel.add(diskField);
        topPanel.add(resetButton);
        frame.add(topPanel, BorderLayout.NORTH);

        // Lienzo visual principal
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(PANEL_WIDTH, TOWER_HEIGHT));
        layeredPane.setLayout(null);

        towerPanels = new JPanel[3];
        for (int i = 0; i < 3; i++) {
            towerPanels[i] = new JPanel();
            towerPanels[i].setLayout(new BoxLayout(towerPanels[i], BoxLayout.Y_AXIS));
            towerPanels[i].setOpaque(false);
            towerPanels[i].setBounds(i * TOWER_WIDTH + 50, 50, TOWER_WIDTH - 100, TOWER_HEIGHT - 100);
            layeredPane.add(towerPanels[i], JLayeredPane.DEFAULT_LAYER);

            // Pilar de torre (visual)
            JLabel pillar = new JLabel();
            pillar.setOpaque(true);
            pillar.setBackground(Color.GRAY);
            pillar.setBounds(i * TOWER_WIDTH + 140, 50, 10, TOWER_HEIGHT - 100);
            layeredPane.add(pillar, JLayeredPane.DEFAULT_LAYER);
        }

        frame.add(layeredPane, BorderLayout.CENTER);

        // Contador de movimientos
        moveCounterLabel = new JLabel("Movimientos: 0", SwingConstants.CENTER);
        moveCounterLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        frame.add(moveCounterLabel, BorderLayout.SOUTH);
    }

    // Mostrar ventana
    public void show() {
        frame.setVisible(true);
    }

    // Getters
    public JFrame getFrame() {
        return frame;
    }

    public JTextField getDiskField() {
        return diskField;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JPanel[] getTowerPanels() {
        return towerPanels;
    }

    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    public void updateMoveCount(int count) {
        moveCounterLabel.setText("Movimientos: " + count);
    }
}
