package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgorithm implements Explorer {
    private String[][] maze;
    private MazeMovement movement; //initialize core movement class 
    private static final String[] DIRECTIONS = {"NORTH", "EAST", "SOUTH", "WEST"}; //set directions for movement
    
    @Override
    public String findPath(Maze mazeClass) {
        maze = mazeClass.getMaze(); // retrieve maze object from maze class
        movement = new MazeMovement(mazeClass); //pass maze argument
        StringBuilder path = new StringBuilder(); //initialize stringbuilder to append path
        int startRow = mazeClass.getEntryRow(); //get start position, which is  first column or mazeClass.getExitRow() which is last column
        int currentCol = 0; //mazeClass.getRow() - 2 would get the last column to begin from west 
        String directionValue = DIRECTIONS[1]; // Start facing EAST
        
        while (currentCol != mazeClass.getCol() -1) { 
            if (movement.canMoveRight(startRow, currentCol, directionValue)) { //based off row,col and directiton first verify if you can move right
                int[] nextPosition = movement.getNextPosition(startRow, currentCol, directionValue); //pass row, col and direction again to retrieve next position
                directionValue = movement.getNextDirection(directionValue); //based off current direction, and you can move right get next direction
                startRow = nextPosition[0]; //represents row, might get incrimented based off direction for next position
                currentCol = nextPosition[1]; //represents column
                path.append("RF");
            } 
            else if (movement.canMoveStraight(startRow, currentCol, directionValue)) {
                int[] straightPosition = movement.getStraightPosition(startRow, currentCol, directionValue); //if you can't move right, check if you can move straight
                startRow = straightPosition[0];
                currentCol = straightPosition[1];
                path.append("F");
            } 
            else {
                directionValue = movement.getTurnLeftDirection(directionValue); //if you can't move right or straight, turn left
                path.append("L");
            }
        }
        return path.toString();
    }
}