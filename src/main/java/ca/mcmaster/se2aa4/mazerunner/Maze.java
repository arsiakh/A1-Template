package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Maze {
   
    private String[][] maze;
    private List<String> lines;
    private int row;
    private int col;
    private String entryExit;

    public Maze(List<String> lines) {
        this.lines = lines;
        this.row = lines.size();
        this.col = lines.get(0).length();
        this.maze = new String[row][col];
        this.entryExit = "";
        copyMaze();
        checkValidEntryOrExit();
        printMaze();
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
    
    public String getEntryExit() {
        return entryExit;
    }

    public void copyMaze() {
        for (int i = 0; i < row; i++) {
            String currentLine = lines.get(i);
            for (int j = 0; j < col; j++) {
                if (currentLine.charAt(j) == '#') {
                    maze[i][j] = "WALL";
                } else if (currentLine.charAt(j) == ' ') {
                    maze[i][j] = "PASS";
                }
            }
        }
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
        StringBuilder openRows = new StringBuilder();
        for (int i = 0; i < row; i++) {
            if (maze[i][0] == "PASS") {
                maze[i][0] = "ENTRY";
                openRows.append(i);
            }
            if (maze[i][col - 1] == "PASS") {
                maze[i][col - 1] = "EXIT";
                openRows.append(i);
            }
        }
        entryExit = openRows.toString();
    }

    
    
}


