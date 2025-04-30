package arcade.view;

import javax.swing.*;
import java.awt.*;

public class NQueensView {
    private JFrame frame;
    private JTextField nInputField;
    private JButton solveButton;
    private NQueensBoardPanel boardPanel;

    public NQueensView() {
        frame = new JFrame("Problema de las N Reinas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 650);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Tamaño del tablero (N): "));
        nInputField = new JTextField(5);
        solveButton = new JButton("Resolver");
        topPanel.add(nInputField);
        topPanel.add(solveButton);

        boardPanel = new NQueensBoardPanel();
        boardPanel.setPreferredSize(new Dimension(600, 600));

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.pack();
    }

    public void show() {
        frame.setVisible(true);
    }

    public JButton getSolveButton() {
        return solveButton;
    }

    public JTextField getNInputField() {
        return nInputField;
    }

    public NQueensBoardPanel getBoardPanel() {
        return boardPanel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
