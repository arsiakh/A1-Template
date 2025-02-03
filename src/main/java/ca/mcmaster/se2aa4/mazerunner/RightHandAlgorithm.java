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
        int startRow = mazeClass.getEntryRow(); //get start position, which is always first column
        int currentCol = 0;
        String directionValue = DIRECTIONS[1]; // Start facing EAST
        
        while (!"EXIT".equals(maze[startRow][currentCol])) { 
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
/* 
public class RightHandAlgorithm implements Explorer{ //interface explorer that will be impliemented in a righthandrule class or another algorithm class ( methods must be used the sam
    private String[][] maze;

    @Override
    public String findPath(Maze mazeClass) {
        maze = mazeClass.getMaze();
        StringBuilder path = new StringBuilder();
        String[] direction = {"NORTH", "EAST", "SOUTH", "WEST"};
        int startRow = mazeClass.getEntryRow(); // entry row i.e (can be 4)
        int currentCol = 0; //always start on east side so leftmost column
        String directionValue = direction[1];
         
        while (!"EXIT".equals(maze[startRow][currentCol])) {
            // Check if current position is the exit
            //System.out.println("Current Position: (" + startRow + ", " + currentCol + "), Current Place:" + maze[startRow][currentCol] + "Direction: " + directionValue);
            if ("EAST".equals(directionValue)) {
                // First check right (South)
                if ("PASS".equals(maze[startRow + 1][currentCol]) || "EXIT".equals(maze[startRow + 1][currentCol])) {
                    directionValue = direction[2];
                    startRow++;
                    path.append("RF");
                }
                // If right is blocked, try to go straight
                else if ("PASS".equals(maze[startRow][currentCol + 1]) || "EXIT".equals(maze[startRow][currentCol + 1])) {
                    currentCol++;
                    path.append("F");
                }
                // If straight is blocked, turn left
                else {
                    directionValue = direction[0];
                    path.append("L");
                }
            }
            else if ("SOUTH".equals(directionValue)) {
                // First check right (West)
                if ("PASS".equals(maze[startRow][currentCol - 1]) || "EXIT".equals(maze[startRow][currentCol - 1])) {
                    directionValue=direction[3];
                    currentCol--;
                    path.append("RF");
                }
                // If right is blocked, try to go straight
                else if ("PASS".equals(maze[startRow + 1][currentCol]) || "EXIT".equals(maze[startRow + 1][currentCol])) {
                    startRow++;
                    path.append("F");
                }
                // If straight is blocked, turn left
                else {
                    directionValue=direction[1];
                    path.append("L");
                }
            }
            else if ("WEST".equals(directionValue)) {
                // First check right (North)
                if ("PASS".equals(maze[startRow - 1][currentCol]) || "EXIT".equals(maze[startRow - 1][currentCol])) {
                    directionValue = direction[0];
                    startRow--;
                    path.append("RF");
                    
                }
                // If right is blocked, try to go straight
                else if ("PASS".equals(maze[startRow][currentCol - 1]) || "EXIT".equals(maze[startRow][currentCol - 1])) {
                    currentCol--;
                    path.append("F");
                    
                }
                // If straight is blocked, turn left
                else {
                    directionValue = direction[2];
                    path.append("L");
                }
            }
            else if ("NORTH".equals(directionValue)) {
                // First check right (East)
                if ("PASS".equals(maze[startRow][currentCol + 1]) || "EXIT".equals(maze[startRow][currentCol + 1])) {
                    directionValue = direction[1];
                    currentCol++;
                    path.append("RF");
                }
                // If right is blocked, try to go straight
                else if ("PASS".equals(maze[startRow - 1][currentCol]) || "EXIT".equals(maze[startRow - 1][currentCol])) {
                    startRow--;
                    path.append("F");
                }
                // If straight is blocked, turn left
                else {
                    directionValue = direction[3];
                    path.append("L");
                }
            }
           
            
            }
            return path.toString();
               
        }}
            
       

    

*/