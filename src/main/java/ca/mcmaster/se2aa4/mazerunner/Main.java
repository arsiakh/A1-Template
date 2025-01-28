package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        try {
            // create Options object
            Options options = new Options();
            // add i option (expects an argument for the input file)
            options.addOption("i", true, "specify the input file");
            options.addOption("p", true, "verify input path");
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);  

            if (cmd.hasOption("i")) {
                // Retrieve the value of the -i flag
                String inputFile = cmd.getOptionValue("i");
                // Proceed with processing the input file
                logger.info("**** Reading the maze from file " + inputFile);
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                List<String> lines = new ArrayList<>();
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
                Maze maze = new Maze(lines);
                Explorer explorer = new Explorer(maze);
                if (cmd.hasOption("p")) {
                    String path = cmd.getOptionValue("p");
                    if (path.equals(explorer.moveForward())) {
                        logger.info("PATH COMPUTED");
                    } else {
                        logger.info("PATH NOT COMPUTED");
                    }

                }
                else { 
                
                    logger.info(explorer.moveForward());
                    /*  
                    for (String mazeLine : lines) {
                        for (int idx = 0; idx < mazeLine.length(); idx++) {
                            if (mazeLine.charAt(idx) == '#') {
                                logger.trace("WALL ");
                            } else if (mazeLine.charAt(idx) == ' ') {
                                logger.trace("PASS ");
                            }
                        }
                        logger.trace(System.lineSeparator());
                    }*/

                }
            } 
            
            
            
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.warn("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
