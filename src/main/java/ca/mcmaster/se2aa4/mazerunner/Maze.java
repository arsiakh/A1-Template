package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;




public class Maze {
   
    String[][] maze;
    List<String> lines;
    int row;
    int col;

    public Maze(List<String> lines) {
        this.lines = lines;
        this.row = lines.size();
        this.col = lines.get(0).length();
        this.maze = new String[row][col];
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
        for (int i = 0; i < row; i++) {
            if (maze[i][0] == "PASS") {
                maze[i][0] = "ENTRY";
            }
            if (maze[i][col - 1] == "PASS") {
                maze[i][col - 1] = "EXIT";
            }
        }
    }

    public void main() {
        copyMaze();
        checkValidEntryOrExit();
        printMaze();
    }
    
    
}


