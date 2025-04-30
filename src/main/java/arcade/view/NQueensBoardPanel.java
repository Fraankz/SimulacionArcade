package arcade.view;

import javax.swing.*;
import java.awt.*;

public class NQueensBoardPanel extends JPanel {
    private int[][] board;

    public NQueensBoardPanel() {
        this.board = new int[0][0];
    }

    public void setBoard(int[][] board) {
        this.board = board;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (board == null || board.length == 0) return;

        int size = board.length;
        int cellWidth = getWidth() / size;
        int cellHeight = getHeight() / size;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // Fondo blanco o gris
                g2d.setColor((row + col) % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                g2d.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);

                // Dibuja reina y líneas si hay reina
                if (board[row][col] == 1) {
                    drawAttackLines(g2d, row, col, size, cellWidth, cellHeight);
                    g2d.setColor(Color.BLACK);
                    int cx = col * cellWidth + cellWidth / 2;
                    int cy = row * cellHeight + cellHeight / 2;
                    g2d.fillOval(cx - 10, cy - 10, 20, 20);
                }
            }
        }
    }

    private void drawAttackLines(Graphics2D g2d, int row, int col, int size, int cellW, int cellH) {
        int centerX = col * cellW + cellW / 2;
        int centerY = row * cellH + cellH / 2;

        int[][] directions = {
                {-1, 0}, {1, 0},  // vertical: arriba, abajo
                {0, -1}, {0, 1},  // horizontal: izq, der
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // diagonales
        };

        g2d.setColor(Color.GREEN);

        for (int[] dir : directions) {
            int targetRow = row;
            int targetCol = col;

            while (true) {
                int nextRow = targetRow + dir[0];
                int nextCol = targetCol + dir[1];

                if (nextRow < 0 || nextRow >= size || nextCol < 0 || nextCol >= size) {
                    break; // hemos llegado al borde
                }

                targetRow = nextRow;
                targetCol = nextCol;
            }

            int endX = targetCol * cellW + cellW / 2;
            int endY = targetRow * cellH + cellH / 2;

            g2d.drawLine(centerX, centerY, endX, endY);
        }
    }

}
