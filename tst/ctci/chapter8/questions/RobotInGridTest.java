package ctci.chapter8.questions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RobotInGridTest {

    @Test
    void findPathRecursive_oneByone() {
        // Grid:    o
        assertTrue(RobotInGrid.findPathRecursive(new int[1][1]).isEmpty());
    }

    @Test
    void findPathRecursive_twoBytwo_pathDown() {
        // Grid:    o x
        //          o o
        int[][] grid = new int[2][2];
        grid[0][1] = 1;
        assertEquals(List.of(RobotInGrid.DIRECTION.DOWN, RobotInGrid.DIRECTION.RIGHT), RobotInGrid.findPathRecursive(grid));
    }

    @Test
    void findPathRecursive_twoBytwo_pathRight() {
        // Grid:    o o
        //          o x
        int[][] grid = new int[2][2];
        grid[1][0] = 1;
        assertEquals(List.of(RobotInGrid.DIRECTION.RIGHT, RobotInGrid.DIRECTION.DOWN), RobotInGrid.findPathRecursive(grid));
    }

    @Test
    void findPathRecursive_threeBythree_openPath() {
        // Grid:    o x x
        //          o o o
        //          x x o
        int[][] grid = new int[3][3];
        grid[0][1] = 1;
        grid[0][2] = 1;
        grid[2][0] = 1;
        grid[2][1] = 1;
        assertEquals(List.of(
                RobotInGrid.DIRECTION.DOWN,
                RobotInGrid.DIRECTION.RIGHT,
                RobotInGrid.DIRECTION.RIGHT,
                RobotInGrid.DIRECTION.DOWN),
                RobotInGrid.findPathRecursive(grid));
    }

    @Test
    void findPathRecursive_threeBythree_blockedPath() {
        // Grid:    o x x
        //          o x o
        //          x x o
        int[][] grid = new int[3][3];
        grid[0][1] = 1;
        grid[0][2] = 1;
        grid[1][1] = 1;
        grid[2][0] = 1;
        grid[2][1] = 1;
        assertEquals(List.of(), RobotInGrid.findPathRecursive(grid));
    }

}