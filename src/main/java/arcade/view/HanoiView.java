package arcade.view;

import javax.swing.*;
import java.awt.*;

public class HanoiView {
    private JFrame frame;
    private JTextField diskField;
    private JButton resetButton;
    private JTextArea outputArea;

    private JButton moveAtoB;
    private JButton moveAtoC;
    private JButton moveBtoA;
    private JButton moveBtoC;
    private JButton moveCtoA;
    private JButton moveCtoB;

    public HanoiView() {
        frame = new JFrame("Torres de Hanoi - Modo Manual");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Número de discos (1-8):"));
        diskField = new JTextField(5);
        topPanel.add(diskField);

        resetButton = new JButton("Reiniciar");
        topPanel.add(resetButton);

        JPanel movePanel = new JPanel(new GridLayout(2, 3, 10, 10));
        moveAtoB = new JButton("Mover A → B");
        moveAtoC = new JButton("Mover A → C");
        moveBtoA = new JButton("Mover B → A");
        moveBtoC = new JButton("Mover B → C");
        moveCtoA = new JButton("Mover C → A");
        moveCtoB = new JButton("Mover C → B");

        movePanel.add(moveAtoB);
        movePanel.add(moveAtoC);
        movePanel.add(moveBtoA);
        movePanel.add(moveBtoC);
        movePanel.add(moveCtoA);
        movePanel.add(moveCtoB);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(movePanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

    // Getters para el controlador
    public JFrame getFrame() {
        return frame;
    }

    public JTextField getDiskField() {
        return diskField;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JTextArea getOutputArea() {
        return outputArea;
    }

    public JButton getMoveAtoB() {
        return moveAtoB;
    }

    public JButton getMoveAtoC() {
        return moveAtoC;
    }

    public JButton getMoveBtoA() {
        return moveBtoA;
    }

    public JButton getMoveBtoC() {
        return moveBtoC;
    }

    public JButton getMoveCtoA() {
        return moveCtoA;
    }

    public JButton getMoveCtoB() {
        return moveCtoB;
    }
}
