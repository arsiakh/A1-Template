package ca.mcmaster.se2aa4.mazerunner;
import org.apache.commons.cli.*;

public class InputFlags { 

    protected Options options;
    protected CommandLineParser parser;
    protected CommandLine cmd;

    public InputFlags(String[] args) throws ParseException {
        options = new Options();
        parser = new DefaultParser();
        options.addOption("i", true, "specify the input file"); //add options for input file and path
        options.addOption("p", true, "verify input path");

        this.cmd = parser.parse(options, args);//parse the command line arguments
    }

    public boolean hasInputFile() { 
        return cmd.hasOption("i"); //check if the input file option is present
    }

    public String getInputFile() { 
        return cmd.getOptionValue("i"); // return the value of the input file
    }

    public boolean hasPath() { 
        return cmd.hasOption("p"); //check if the path option is present
    }

    public String getPath() { 
        return cmd.getOptionValue("p"); //return the value of the path
    }

}