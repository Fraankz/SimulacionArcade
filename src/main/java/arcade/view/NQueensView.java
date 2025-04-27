package arcade.view;

import javax.swing.*;
import java.awt.*;

public class NQueensView {
    private JFrame frame;
    private JTextField nInputField;
    private JButton solveButton;
    private JPanel boardPanel;

    public NQueensView() {
        frame = new JFrame("Problema de las N Reinas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Solo cierra esta ventana
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null); // Centrar

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Parte superior: input y botón
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Tamaño del tablero (N): "));
        nInputField = new JTextField(5);
        solveButton = new JButton("Resolver");
        topPanel.add(nInputField);
        topPanel.add(solveButton);

        // Parte central: el tablero (vacío al principio)
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(8, 8)); // Por defecto, 8x8
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
    }

    public void show() {
        frame.setVisible(true);
    }

    // Getters para que el controlador pueda acceder a los componentes
    public JButton getSolveButton() {
        return solveButton;
    }

    public JTextField getNInputField() {
        return nInputField;
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
