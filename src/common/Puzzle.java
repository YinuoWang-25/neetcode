package common;

import java.util.ArrayList;
import java.util.List;

enum Shape {
    Diamond,
    Heart,
    Spade,
    Club,
}

enum Type {
    connector,
    Receiptor,
}

class Side {
    Shape shape;
    Type type;
}

class Puzzle {
    Side up;
    Side bottom;
    Side left;
    Side right;

    // rotate it 90 degree by time wise
    public void rotate() {

    }

    ;
}

class MyCode {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }

    public void solvePuzzel(Puzzle[] puzzles) {
        dfs(puzzles, new boolean[9], new ArrayList<Puzzle>());
    }

    private void dfs(Puzzle[] puzzles, boolean[] used, List<Puzzle> curSolution) {
        if (curSolution.size() == 9) {
            // print out the solution

        }
        for (int i = 0; i < puzzles.length; i++) {
            if (used[i]) continue;
            // try to put puzzles[i]
            for (int k = 0; k < 4; k++) {
                // check
                if (canFitin(curSolution, puzzles[i])) {
                    curSolution.add(puzzles[i]);
                    used[i] = true;
                    dfs(puzzles, used, curSolution);
                    used[i] = false;
                    curSolution.remove(curSolution.size() - 1);
                }
                puzzles[i].rotate();
            }
        }
    }

    private boolean canFitin(List<Puzzle> curSolution, Puzzle p) {
        // find all puzzles we need to check:
        int index = curSolution.size() + 1;
        int row = index / 3;
        int col = index % 3;
        if (row > 1) {
            // up side of current puzzel
            Side curUp = p.up;
            Side prevBottom = curSolution.get(index - 3).bottom;
            if (curUp.shape != prevBottom.shape) {
                return false;
            }
            if (curUp.type == prevBottom.type) {
                return false;
            }
        }
        if (col > 1) {
            Side curLeft = p.left;
            Side prevRight = curSolution.get(index - 1).right;
            if (curLeft.shape != prevRight.shape) {
                return false;
            }
            if (curLeft.type == prevRight.type) {
                return false;
            }
        }
        return true;
    }
}

