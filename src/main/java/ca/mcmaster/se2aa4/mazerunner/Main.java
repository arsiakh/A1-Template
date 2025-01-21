package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;

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
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);  

            if (cmd.hasOption("i")) {
                // Retrieve the value of the -i flag
                String inputFile = cmd.getOptionValue("i");
                // Proceed with processing the input file
                logger.info("**** Reading the maze from file " + inputFile);
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                String line;
                while ((line = reader.readLine()) != null) {
                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') {
                            logger.trace("WALL ");
                        } else if (line.charAt(idx) == ' ') {
                            logger.trace("PASS ");
                        }
                    }
                    logger.trace(System.lineSeparator());
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
