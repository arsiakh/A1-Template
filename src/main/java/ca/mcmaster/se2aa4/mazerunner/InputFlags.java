package ca.mcmaster.se2aa4.mazerunner;
import org.apache.commons.cli.*;

public class InputFlags { 

    protected Options options;
    protected CommandLineParser parser;
    protected CommandLine cmd;

    public InputFlags(String[] args) throws ParseException {
        options = new Options();
        parser = new DefaultParser();
        options.addOption("i", true, "specify the input file");
        options.addOption("p", true, "verify input path");

        this.cmd = parser.parse(options, args);
    }

    public boolean hasInputFile() { 
        return cmd.hasOption("i");
    }

    public String getInputFile() { 
        return cmd.getOptionValue("i");
    }

    public boolean hasPath() { 
        return cmd.hasOption("p");
    }

    public String getPath() { 
        return cmd.getOptionValue("p");
    }

}