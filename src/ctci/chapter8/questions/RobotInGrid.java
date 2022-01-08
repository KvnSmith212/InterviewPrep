package ctci.chapter8.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 8.2 Robot In a Grid: Imagine a robot sitting in the upper left corner of a grid with 'r' rows and 'c' columns. The
 * robot can move in two directions, right and down. Certain cells are off limits and can not be stepped on. Design an
 * algorithm to find a path for the robot from top left to bottom right.
 */
public class RobotInGrid {

    /**
     * Finds a path from top left of grid to bottom right, where top left is denoted by [0][0] and bottom right is [r][c].
     * Cells containing 0 are considered legitimate, else cells may not be stepped on. Return of empty list implies
     * there is no valid path.
     * @param grid
     * @return path from top left to bottom right.
     */
    public static List<DIRECTION> findPathRecursive(int[][] grid) {
        return findPathRecursive(grid, grid.length - 1, grid[0].length - 1);
    }

    private static List<DIRECTION> findPathRecursive(int[][] grid, int row, int col) {

        // Check if we can go down, and find path recursively to do so.
        if (row > 0 && grid[row-1][col] == 0) {

            if (row == 1 && col == 0) {
                return new ArrayList<>(List.of(DIRECTION.DOWN));
            }

            List<DIRECTION> fromTop = findPathRecursive(grid, row - 1, col);
            if (!fromTop.isEmpty()) {
                fromTop.add(DIRECTION.DOWN);
                return fromTop;
            }
        }

        // Check if we can go right, and find path recursively to do so.
        if (col > 0 && grid[row][col-1] == 0) {

            if (row == 0 && col == 1) {
                return new ArrayList<>(List.of(DIRECTION.RIGHT));
            }

            List<DIRECTION> fromLeft = findPathRecursive(grid, row, col - 1);
            if (!fromLeft.isEmpty()) {
                fromLeft.add(DIRECTION.RIGHT);
                return fromLeft;
            }
        }

        // Either we are at [0][0], or there is no solution.
        return new ArrayList<>();
    }

    public enum DIRECTION {
        RIGHT,
        DOWN
    }
}
