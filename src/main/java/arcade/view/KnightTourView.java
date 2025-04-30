package arcade.view;

import javax.swing.*;
import java.awt.*;

public class KnightTourView {
    private JFrame frame;
    private JTextField boardSizeField;
    private JTextField startXField;
    private JTextField startYField;
    private JButton solveButton;
    private JPanel boardPanel;

    public KnightTourView() {
        frame = new JFrame("Recorrido del Caballo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel superior
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Tamaño del tablero:"));
        boardSizeField = new JTextField("8", 3);
        topPanel.add(boardSizeField);
        topPanel.add(new JLabel("Inicio X:"));
        startXField = new JTextField("0", 3);
        topPanel.add(startXField);
        topPanel.add(new JLabel("Inicio Y:"));
        startYField = new JTextField("0", 3);
        topPanel.add(startYField);
        solveButton = new JButton("Resolver");
        topPanel.add(solveButton);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(8, 8)); // por defecto

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
    }

    public void show() {
        frame.setVisible(true);
    }

    public JTextField getBoardSizeField() { return boardSizeField; }
    public JTextField getStartXField() { return startXField; }
    public JTextField getStartYField() { return startYField; }
    public JButton getSolveButton() { return solveButton; }
    public JPanel getBoardPanel() { return boardPanel; }
    public JFrame getFrame() { return frame; }
}
