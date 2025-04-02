package ca.mcmaster.se2aa4.mazerunner;


import org.apache.commons.cli.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        
        try {
            InputFlags flags = new InputFlags(args);
            
            if (flags.hasInputFile()) {//-i flag

                String inputFile = flags.getInputFile(); //retrieve encapsulated information for input file
                
                MazeLoader loader = new MazeLoader(inputFile); //create new object for maze loader to get info from file
                Maze maze = new Maze(loader); //create new object for maze which gets file matrix from MazeLoader
                Explorer explorer = new RightHandAlgorithm(); //create new object for explorer using right hand algorithm
                MazeCommandProcessor commandProcessor = new MazeCommandProcessor();

            
                
                if (flags.hasPath()) { //-p flag
                    String path = flags.getPath(); //retrieve encapsulated information for path
                    VerifyPathCommand verifyCommand = new VerifyPathCommand(maze, path);
                    commandProcessor.executeCommand(verifyCommand);
                    
                }
                else { 
                    FindPathCommand findPathCommand = new FindPathCommand(maze, explorer);
                    commandProcessor.executeCommand(findPathCommand);

                }
            } 
            
        } catch(ParseException e) {
            System.err.println("/!\\ Failed to parse command line arguments /!\\ " + e);
        } catch(Exception e) {
            System.err.println("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.warn("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
