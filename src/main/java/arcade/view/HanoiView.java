package arcade.view;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class HanoiView {
    private final JFrame frame;
    private final JTextField diskField;
    private final JButton resetButton;
    private final JPanel[] towerPanels;
    private final JLabel moveCounterLabel;

    public HanoiView() {
        frame = new JFrame("Torres de Hanoi");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Panel superior
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Número de discos (1–8):"));
        diskField = new JTextField(5);
        resetButton = new JButton("Reiniciar");
        topPanel.add(diskField);
        topPanel.add(resetButton);
        frame.add(topPanel, BorderLayout.NORTH);

        // Panel de torres
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

        // Contador de movimientos
        moveCounterLabel = new JLabel("Movimientos: 0", SwingConstants.CENTER);
        moveCounterLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        frame.add(moveCounterLabel, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

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

    public void highlightTower(int index, boolean highlight) {
        if (highlight) {
            towerPanels[index].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        } else {
            towerPanels[index].setBorder(BorderFactory.createTitledBorder("Torre " + (char) ('A' + index)));
        }
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

    public void updateMoveCount(int count) {
        moveCounterLabel.setText("Movimientos: " + count);
    }
}
