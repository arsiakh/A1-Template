package ca.mcmaster.se2aa4.mazerunner;

public abstract class MazePathFinder implements Explorer{

    protected static final String[] DIRECTIONS = {"NORTH", "EAST", "SOUTH", "WEST"};
    
    // Template Method
    @Override
    public final String findPath(Maze mazeClass) {
        // Fixed sequence of steps
        String[][] maze = prepareMaze(mazeClass);
        MazeMovement movement = prepareMovement(mazeClass);
        int startRow = determineStartRow(mazeClass);
        
        return navigateMaze(maze, movement, startRow, mazeClass);
    }
    
    // Hook methods that can be overridden
    protected String[][] prepareMaze(Maze mazeClass) {
        return mazeClass.getMaze();
    }
    
    protected MazeMovement prepareMovement(Maze mazeClass) {
        return new MazeMovement(mazeClass);
    }
    
    protected int determineStartRow(Maze mazeClass) {
        return mazeClass.getEntryRow();
    }
    
    // Abstract method to be implemented by subclasses
    protected abstract String navigateMaze(
        String[][] maze, 
        MazeMovement movement, 
        int startRow, 
        Maze mazeClass
    );
    
}
