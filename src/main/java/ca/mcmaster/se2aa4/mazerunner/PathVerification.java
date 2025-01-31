package ca.mcmaster.se2aa4.mazerunner;

public class PathVerification { 

    private Maze mazeClass;
    private String[][] maze;
    private String path;

    public PathVerification(Maze mazeClass, String path) { 
        this.mazeClass = mazeClass;
        this.maze = mazeClass.getMaze();    
        this.path = path;
    }

    public boolean verifyPath() {
        //String[] directions = {"NORTH", "EAST", "SOUTH", "WEST"};
        int row = mazeClass.getEntryRow();
        int col = 0;
        String direction = "EAST"; // Start facing EAST
    
        for (char move : path.toCharArray()) {
            if (move == 'L') {
                direction = turnLeft(direction);
            } else if (move == 'R') {
                direction = turnRight(direction);
            } else if (move == 'F') {
                int newRow = row;
                int newCol = col;
    
                switch (direction) {
                    case "NORTH": newRow--; break;
                    case "EAST": newCol++; break;
                    case "SOUTH": newRow++; break;
                    case "WEST": newCol--; break;
                }
    
                if (!isValidMove(newRow, newCol)) {
                    return false; // Invalid move
                }
    
                row = newRow;
                col = newCol;
            }
        }
    
        return "EXIT".equals(maze[row][col]); // Check if we reached the exit
    }
    
    private String turnLeft(String direction) {
        if (direction.equals("NORTH")) return "WEST";
        if (direction.equals("WEST")) return "SOUTH";
        if (direction.equals("SOUTH")) return "EAST";
        return "NORTH"; // If facing EAST
    }
    
    private String turnRight(String direction) {
        if (direction.equals("NORTH")) return "EAST";
        if (direction.equals("EAST")) return "SOUTH";
        if (direction.equals("SOUTH")) return "WEST";
        return "NORTH"; // If facing WEST
    }
    
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length 
               && ("PASS".equals(maze[row][col]) || "EXIT".equals(maze[row][col]));
    }

    
        
    
}