package arcade.model.hanoi;

import java.util.List;

public class HanoiSolver {
    public void solve(int n, String fromRod, String toRod, String auxRod, List<String> moves) {
        if (n == 1) {
            moves.add("Mover disco 1 de " + fromRod + " a " + toRod);
            return;
        }
        solve(n - 1, fromRod, auxRod, toRod, moves);
        moves.add("Mover disco " + n + " de " + fromRod + " a " + toRod);
        solve(n - 1, auxRod, toRod, fromRod, moves);
    }
}
