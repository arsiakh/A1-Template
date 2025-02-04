package ca.mcmaster.se2aa4.mazerunner;


public class PathVerification {
    private final Maze mazeClass;
    private final String[][] maze;
    private final MazeMovement movement; //use this class for modularity 
    
    public PathVerification(Maze mazeClass) {
        this.mazeClass = mazeClass;
        this.maze = mazeClass.getMaze();
        this.movement = new MazeMovement(mazeClass);
    }

    public boolean verifyPath(String path) {
        if (path.matches(".*\\d+.*")) {
            PathFormat formatter = new PathFormat(path);
            path = formatter.pathCanonical();
        }
        int row = mazeClass.getEntryRow(); //begin with starting position
        int col = 0;
        String direction = "EAST"; //facing east

        for (char move : path.toCharArray()) { //process each move "FFLRFF"
            if (move == 'L') {
                direction = movement.getTurnLeftDirection(direction); //update direction for left turn
            } else if (move == 'R') {
                direction = movement.getNextDirection(direction); //update direction for right turn
            } else if (move == 'F') {
                int[] newPosition = movement.getStraightPosition(row, col, direction); //determine new position based off direction
                
                if (!movement.isValidPosition(newPosition[0], newPosition[1])) {
                    return false; //return false if movement leads to invalid position (i.e wall/out of bounds)
                }
                
                row = newPosition[0]; //update row and column positioning 
                col = newPosition[1];
            }
        }
        
        return "EXIT".equals(maze[row][col]); //stop once reached exit 
    }
}