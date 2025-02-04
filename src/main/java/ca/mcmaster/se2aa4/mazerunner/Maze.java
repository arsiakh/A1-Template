package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

public class Maze {
   
    private String[][] maze;
    private List<String> lines;
    private int row;
    private int col;
    private int entryRow = -1; //initialize entryRow
    private int exitRow = -1; //initialize exitRow


    public Maze(MazeLoader loader) { 
        lines = loader.loadMaze();//use parameter to load array list
        if (lines.isEmpty()) {
            throw new IllegalStateException("Maze file is empty or could not be read."); //if it failed to read file and array is empty
        }
        this.row = lines.size(); //get the size of the array
        this.col = lines.get(0).length(); //get the length of the first line
        this.maze = copyMaze(); //create a new maze object
        this.entryRow = -1;
        checkValidEntryOrExit(); //determine entry/exit
    
    }


    // Getter for maze grid
    public String[][] getMaze() {
        return maze;
    }

    // Setter for maze grid
    public void setMaze(String[][] maze) {
        this.maze = maze;
    }

    // Getter for lines
    public List<String> getLines() {
        return lines;
    }

    // Getter for rows
    public int getRow() {
        return row;
    }

    // Getter for columns
    public int getCol() {
        return col;
    }
    
    public int getEntryRow() {
        return entryRow;
    }
    public int getExitRow() {
        return exitRow;
    }


    public String[][] copyMaze() {
        maze = new String[row][col]; //instantiate maze object
        for (int i = 0; i < row; i++) {
            String currentLine = lines.get(i); //get current line
            for (int j = 0; j < col; j++) {
                if (currentLine.charAt(j) == '#') { //if current line is a wall
                    maze[i][j] = "WALL";
                } else if (currentLine.charAt(j) == ' ') {
                    maze[i][j] = "PASS";
                }
            }
        }
        return maze;
    }

    public void printMaze() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void checkValidEntryOrExit() { 
        for (int i = 0; i < row; i++) {
            if (maze[i][0] == "PASS") { //if first column has a pass change it to entry
                maze[i][0] = "EXIT";
                entryRow = i;
            }
            if (maze[i][col - 1] == "PASS") {
                maze[i][col - 1] = "EXIT";
                exitRow = i;
                
            }
        }

    }

    
    
}


