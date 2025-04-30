package arcade.controller;

import arcade.model.hanoi.HanoiGame;
import arcade.view.HanoiView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class DragManager {
    private final HanoiView view;
    private final HanoiGame game;
    private final JLabel[][] diskLabels;
    private JLabel draggingLabel;
    private Point offset;
    private int fromTower = -1;

    public DragManager(HanoiView view, HanoiGame game) {
        this.view = view;
        this.game = game;
        this.diskLabels = new JLabel[3][10]; // Máximo 10 discos por torre
    }

    public void renderTowers() {
        JPanel[] towers = view.getTowerPanels();
        Stack<Integer>[] states = game.getTowers();

        // Limpiar paneles y reiniciar referencias
        for (int t = 0; t < 3; t++) {
            towers[t].removeAll();
            Arrays.fill(diskLabels[t], null);

            List<Integer> disks = new ArrayList<>(states[t]);
            Collections.reverse(disks);

            for (int i = 0; i < disks.size(); i++) {
                int disk = disks.get(i);
                JLabel label = createDiskLabel(disk, t);
                towers[t].add(label);
                diskLabels[t][i] = label;
            }

            towers[t].revalidate();
            towers[t].repaint();
        }
    }

    private JLabel createDiskLabel(int size, int towerIndex) {
        JLabel label = new JLabel("■".repeat(size), SwingConstants.CENTER);
        label.setFont(new Font("Monospaced", Font.BOLD, 12 + size * 2));
        label.setForeground(new Color(30, 100 + size * 10, 200));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Solo el disco superior será arrastrable
        int topIndex = game.getTowers()[towerIndex].size() - 1;
        if (diskLabels[towerIndex][topIndex] == null) {
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    startDrag(label, towerIndex, e);
                }
            });
            label.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    dragDisk(e);
                }
            });
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    endDrag(e);
                }
            });
        }

        return label;
    }

    private void startDrag(JLabel label, int tower, MouseEvent e) {
        draggingLabel = label;
        fromTower = tower;
        offset = e.getPoint();

        view.getLayeredPane().add(draggingLabel, JLayeredPane.DRAG_LAYER);
        Point labelLoc = SwingUtilities.convertPoint(label, e.getPoint(), view.getLayeredPane());
        draggingLabel.setLocation(labelLoc.x - offset.x, labelLoc.y - offset.y);
        draggingLabel.setSize(label.getPreferredSize());
    }

    private void dragDisk(MouseEvent e) {
        if (draggingLabel == null) return;
        Point mouseLoc = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), view.getLayeredPane());
        draggingLabel.setLocation(mouseLoc.x - offset.x, mouseLoc.y - offset.y);
    }

    private void endDrag(MouseEvent e) {
        if (draggingLabel == null) return;

        int targetTower = detectTower(draggingLabel.getBounds().getCenterX());
        view.getLayeredPane().remove(draggingLabel);
        draggingLabel = null;
        view.getLayeredPane().repaint();

        if (targetTower != -1 && game.move(fromTower, targetTower)) {
            renderTowers();
            view.updateMoveCount(game.getMoveCount());

            if (game.isVictory()) {
                JOptionPane.showMessageDialog(view.getFrame(), "¡Has ganado en " + game.getMoveCount() + " movimientos!");
            }
        } else {
            JOptionPane.showMessageDialog(view.getFrame(), "Movimiento inválido.");
            renderTowers();
        }

        fromTower = -1;
    }

    private int detectTower(double x) {
        for (int i = 0; i < 3; i++) {
            Rectangle bounds = view.getTowerPanels()[i].getBounds();
            if (x >= bounds.getX() && x <= bounds.getX() + bounds.getWidth()) {
                return i;
            }
        }
        return -1;
    }
}
