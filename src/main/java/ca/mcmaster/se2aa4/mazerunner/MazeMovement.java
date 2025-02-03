package ca.mcmaster.se2aa4.mazerunner;

public class MazeMovement {
    private static final String[] DIRECTIONS = {"NORTH", "EAST", "SOUTH", "WEST"};

    private String[][] maze;

    public MazeMovement(Maze mazeClass) {
        this.maze = mazeClass.getMaze(); //instantiate maze object
    }

    public boolean canMoveRight(int row, int col, String currentDirection) {
        int[] position = getNextPosition(row, col, currentDirection); //retrive next position based off row, col and current direction
        return isValidPosition(position[0], position[1]); //verify row and col is valid 
    }

    public boolean canMoveStraight(int row, int col, String currentDirection) {
        int[] position = getStraightPosition(row, col, currentDirection);
        return isValidPosition(position[0], position[1]);
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && //only valid if row and col are within maze bounds, and their position is pass or exit (not wall)
               ("PASS".equals(maze[row][col]) || "EXIT".equals(maze[row][col]));
    }

    public String getNextDirection(String currentDirection) {
        if ("EAST".equals(currentDirection)) { //getting next direction from right turns
            return DIRECTIONS[2];   // SOUTH
        } 
        if ("SOUTH".equals(currentDirection)) 
        {return DIRECTIONS[3]; 
        } // WEST
        if ("WEST".equals(currentDirection)) 
        {return DIRECTIONS[0]; 
        }  // NORTH
        return DIRECTIONS[1];  // EAST (when facing NORTH)
    }

    public String getTurnLeftDirection(String currentDirection) { //get next direction from left turns
        if ("EAST".equals(currentDirection)) {
            return DIRECTIONS[0]; }  // NORTH
        if ("SOUTH".equals(currentDirection)) {
            return DIRECTIONS[1]; } // EAST
        if ("WEST".equals(currentDirection)) {
            return DIRECTIONS[2]; }  // SOUTH
        return DIRECTIONS[3];  // WEST (when facing NORTH)
    }

    public int[] getNextPosition(int row, int col, String currentDirection) { //based off row, col and current direction, to move along the path incriment either row or col, this is for turns only
        if ("EAST".equals(currentDirection)) {
            return new int[]{row + 1, col};  }   // Check South
        if ("SOUTH".equals(currentDirection)) {

        return new int[]{row, col - 1};  }  // Check West
        if ("WEST".equals(currentDirection)) {
            return new int[]{row - 1, col};  }   // Check North
        return new int[]{row, col + 1};  // Check East (when facing NORTH)
    }

    public int[] getStraightPosition(int row, int col, String currentDirection) { //based off row, col and current direction move along straight in the path
        if ("EAST".equals(currentDirection)) 
        {return new int[]{row, col + 1}; }    // Move East
        if ("SOUTH".equals(currentDirection)) 
        {return new int[]{row + 1, col};  }  // Move South
        if ("WEST".equals(currentDirection)) 
        {return new int[]{row, col - 1};   }  // Move West
        return new int[]{row - 1, col};  // Move North (when facing NORTH)
    }
    


    
}
