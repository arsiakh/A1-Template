package ca.mcmaster.se2aa4.mazerunner;

public class Explorer {

    private Maze mazeClass;
    private String[][] maze;


    public Explorer(Maze mazeClass) { 
        this.mazeClass = mazeClass;
        this.maze = mazeClass.getMaze();
                
    }

    public String moveForward() { 
        String openRows = mazeClass.getEntryExit();
        int cols = mazeClass.getCol();
        int firstDigit = Character.getNumericValue(openRows.charAt(0));
        int secondDigit = Character.getNumericValue(openRows.charAt(1));
        int currentCol = 1;
        StringBuilder path = new StringBuilder();
        while (!"EXIT".equals(maze[secondDigit][currentCol])) {
            if ("PASS".equals(maze[firstDigit][currentCol])) {
                // Append "F" for the forward move
                path.append("F");
                // Move to the next column
                currentCol++;
            } 
            }
            return (path.toString());    
        }
            
        


        

    }
    

