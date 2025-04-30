package arcade.view;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class HanoiView {
    private final JFrame frame;
    private final JTextField diskField;
    private final JButton resetButton;
    private final JButton[] moveButtons;
    private final JPanel[] towerPanels;
    private final JLabel moveCounterLabel;

    public HanoiView() {
        frame = new JFrame("Torres de Hanoi");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Panel superior (entrada de discos y reinicio)
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Número de discos (1–8):"));
        diskField = new JTextField(5);
        resetButton = new JButton("Reiniciar");
        topPanel.add(diskField);
        topPanel.add(resetButton);
        frame.add(topPanel, BorderLayout.NORTH);

        // Panel central (torres visuales)
        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        towerPanels = new JPanel[3];
        for (int i = 0; i < 3; i++) {
            towerPanels[i] = new JPanel();
            towerPanels[i].setLayout(new BoxLayout(towerPanels[i], BoxLayout.Y_AXIS));
            towerPanels[i].setBackground(Color.WHITE);
            towerPanels[i].setBorder(BorderFactory.createTitledBorder("Torre " + (char) ('A' + i)));
            centerPanel.add(towerPanels[i]);
        }
        frame.add(centerPanel, BorderLayout.CENTER);

        // Panel inferior (botones de movimiento)
        JPanel bottomPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        moveButtons = new JButton[6];
        String[] labels = {
                "Mover A → B", "Mover A → C",
                "Mover B → A", "Mover B → C",
                "Mover C → A", "Mover C → B"
        };
        for (int i = 0; i < 6; i++) {
            moveButtons[i] = new JButton(labels[i]);
            bottomPanel.add(moveButtons[i]);
        }

        // Contador de movimientos
        moveCounterLabel = new JLabel("Movimientos: 0", SwingConstants.CENTER);
        moveCounterLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(moveCounterLabel, BorderLayout.NORTH);
        southPanel.add(bottomPanel, BorderLayout.CENTER);

        frame.add(southPanel, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

    // Actualiza la vista gráfica de las torres
    public void updateTowers(Stack<Integer>[] towers, int moveCount, boolean victory) {
        for (int i = 0; i < 3; i++) {
            JPanel panel = towerPanels[i];
            panel.removeAll();
            panel.add(Box.createVerticalGlue());

            List<Integer> disks = new ArrayList<>(towers[i]);
            Collections.reverse(disks);
            for (int disk : disks) {
                JLabel label = new JLabel("■".repeat(disk), SwingConstants.CENTER);
                label.setFont(new Font("Monospaced", Font.BOLD, 12 + disk * 2));
                label.setForeground(new Color(30, 100 + disk * 10, 200));
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(label);
            }

            panel.add(Box.createVerticalGlue());
            panel.revalidate();
            panel.repaint();
        }
        moveCounterLabel.setText("Movimientos: " + moveCount);
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

    public JButton[] getMoveButtons() {
        return moveButtons;
    }
}
