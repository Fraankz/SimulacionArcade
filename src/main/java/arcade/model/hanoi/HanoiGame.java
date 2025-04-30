package arcade.model.hanoi;

import arcade.model.game.Game;

import java.util.Stack;

public class HanoiGame implements Game {
    private Stack<Integer>[] towers;
    private int numDisks;

    @SuppressWarnings("unchecked")
    public void reset(int numDisks) {
        this.numDisks = numDisks;
        towers = new Stack[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<>();
        }
        for (int i = numDisks; i >= 1; i--) {
            towers[0].push(i); // todos los discos en la torre A
        }
    }

    public boolean move(char from, char to) {
        int fromIndex = towerIndex(from);
        int toIndex = towerIndex(to);

        if (fromIndex == -1 || toIndex == -1 || towers[fromIndex].isEmpty()) return false;

        int movingDisk = towers[fromIndex].peek();
        if (!towers[toIndex].isEmpty() && towers[toIndex].peek() < movingDisk) return false;

        towers[toIndex].push(towers[fromIndex].pop());
        return true;
    }

    private int towerIndex(char tower) {
        switch (Character.toUpperCase(tower)) {
            case 'A': return 0;
            case 'B': return 1;
            case 'C': return 2;
            default: return -1;
        }
    }

    public boolean isComplete() {
        return towers[2].size() == numDisks;
    }

    public String getState() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append("Torre ").append((char) ('A' + i)).append(": ");
            for (int disk : towers[i]) {
                sb.append(disk).append(" ");
            }
            sb.append("\n");
        }
        if (isComplete()) {
            sb.append("🎉 ¡Has completado el juego!\n");
        }
        return sb.toString();
    }

    @Override
    public void initialize() {}

    @Override
    public boolean solve() { return false; }

    @Override
    public void reset() {

    }
}
