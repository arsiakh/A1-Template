package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MazeLoader { 
    private String inputFile;

    public MazeLoader(String inputFile) {
        this.inputFile = inputFile; //retrieve input file
    }

    
    public List<String> loadMaze() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) { //loop through lines adding each line to a new list
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading input file: " + inputFile, e);
        }
        return lines;
    }
}