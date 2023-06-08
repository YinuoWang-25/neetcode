package math_geometry;

public class L1041_robot_bounded_in_circle {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, direction = 0, deltas[][] = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        for (int j = 0; j < instructions.length(); j++) {
            if (instructions.charAt(j) == 'R') {
                direction = (direction + 1) % 4;
            } else if (instructions.charAt(j) == 'L') {
                direction = (direction + 3) % 4;
            } else {
                x += deltas[direction][0]; y += deltas[direction][1];
            }
        }

        return x == 0 && y == 0 || direction > 0;
    }
}
