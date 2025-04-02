package ca.mcmaster.se2aa4.mazerunner;


public class RightHandAlgorithm extends MazePathFinder {
    @Override
    protected String navigateMaze(
        String[][] maze, 
        MazeMovement movement, 
        int startRow, 
        Maze mazeClass
    ) {
        StringBuilder path = new StringBuilder();
        int currentCol = 0;
        String directionValue = DIRECTIONS[1]; // Start facing EAST
        
        while (currentCol != mazeClass.getCol() - 1) { 
            if (movement.canMoveRight(startRow, currentCol, directionValue)) {
                int[] nextPosition = movement.getNextPosition(startRow, currentCol, directionValue);
                directionValue = movement.getNextDirection(directionValue);
                startRow = nextPosition[0];
                currentCol = nextPosition[1];
                path.append("RF");
            } 
            else if (movement.canMoveStraight(startRow, currentCol, directionValue)) {
                int[] straightPosition = movement.getStraightPosition(startRow, currentCol, directionValue);
                startRow = straightPosition[0];
                currentCol = straightPosition[1];
                path.append("F");
            } 
            else {
                directionValue = movement.getTurnLeftDirection(directionValue);
                path.append("L");
            }
        }
        return path.toString();
    }
}