package arcade.model.hanoi;

import arcade.model.game.Game;

import java.util.*;

public class HanoiGame implements Game {
    private Stack<Integer>[] towers;
    private int numDisks;
    private int moveCount;

    @SuppressWarnings("unchecked")
    public void reset(int numDisks) {
        this.numDisks = numDisks;
        this.moveCount = 0;

        towers = new Stack[3];
        for (int i = 0; i < 3; i++) towers[i] = new Stack<>();

        for (int i = numDisks; i >= 1; i--) towers[0].push(i);
    }

    public boolean move(int from, int to) {
        if (from < 0 || from >= 3 || to < 0 || to >= 3) return false;
        if (towers[from].isEmpty()) return false;

        int disk = towers[from].peek();
        if (!towers[to].isEmpty() && towers[to].peek() < disk) return false;

        towers[to].push(towers[from].pop());
        moveCount++;
        return true;
    }

    public Stack<Integer>[] getTowers() {
        return towers;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public boolean isVictory() {
        return towers[0].isEmpty() && towers[1].isEmpty() && towers[2].size() == numDisks;
    }

    public int getNumDisks() {
        return numDisks;
    }

    @Override
    public void initialize() {

    }

    @Override
    public boolean solve() {
        return false;
    }

    @Override
    public void reset() {

    }
}
