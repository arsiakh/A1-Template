package ca.mcmaster.se2aa4.mazerunner;

public class Explorer {

    private Maze mazeClass;
    private String[][] maze;


    public Explorer(Maze mazeClass) { 
        this.mazeClass = mazeClass;
        this.maze = mazeClass.getMaze();
                
        

    }

    
    public String moveForward() { 
        String openRows = mazeClass.checkValidEntryOrExit();
        int cols = mazeClass.getCol();
        int firstDigit = Character.getNumericValue(openRows.charAt(0));
        int secondDigit = Character.getNumericValue(openRows.charAt(1));
        int i = 1;
        StringBuilder path = new StringBuilder();
        while(!"EXIT".equals(maze[secondDigit][cols-1])) {
            if(maze[firstDigit][i] == "PASS") {
                maze[firstDigit][i] = maze[firstDigit][i+1];
                path.append("F");

            }
         }
         return path.toString();


        

    }
    
}
