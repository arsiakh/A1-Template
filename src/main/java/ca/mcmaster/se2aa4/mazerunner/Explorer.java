package ca.mcmaster.se2aa4.mazerunner;

public class Explorer { //interface explorer that will be impliemented in a righthandrule class or another algorithm class ( methods must be used the same)

    private Maze mazeClass;
    private String[][] maze;


    public Explorer(Maze mazeClass) { 
        this.mazeClass = mazeClass;
        this.maze = mazeClass.getMaze();
                
    }

    public String moveForward() { 
        String[] direction = {"NORTH", "EAST", "SOUTH", "WEST"};
        int entryRow = mazeClass.getEntryRow();
       
        
        int startRow = entryRow;
        int currentCol = 0;
        StringBuilder path = new StringBuilder();
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
            return (path.toString());    
        }
            
        


        

    }

    

