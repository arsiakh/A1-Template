package ca.mcmaster.se2aa4.mazerunner;



import org.apache.commons.cli.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        
        try {
            InputFlags flags = new InputFlags(args); //create new object class for input flags
            if (flags.hasInputFile()) {//-i flag

                String inputFile = flags.getInputFile(); //retrieve encapsulated information for input file
                
                MazeLoader loader = new MazeLoader(inputFile); //create new object for maze loader to get info from file
                Maze maze = new Maze(loader); //create new object for maze which gets file matrix from MazeLoader
                Explorer explorer = new RightHandAlgorithm(); //create new object for explorer using right hand algorithm
            
                
                if (flags.hasPath()) { //-p flag
                    String path = flags.getPath(); //retrieve encapsulated information for path
                    PathVerification pathVerification = new PathVerification(maze); //create new object for path verification
                    if (pathVerification.verifyPath(path)) { //verify path
                        System.out.println("correct path");
                    } else {
                        System.out.println("incorrect path");
                    }
                }
                else { 
                    String generatedPath = explorer.findPath(maze); //generate path using explorer object
                    PathFormat format = new PathFormat(generatedPath); //create new object for path format including canonical and factored
                    System.out.println(format.pathCanonical()); //display results
                    System.out.println(format.pathFactored());

                }
            } 
            
        } catch(ParseException e) {
            logger.error("/!\\ Failed to parse command line arguments /!\\", e);
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.warn("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
