package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MazeTest {
    private MazeLoader loader;
    private Maze maze;
    private Explorer rightHandExplorer;
    private PathVerification pathVerification;

    @BeforeEach
    void setUp() {
        // Create a standard initializer with default parameters
        String testMazeFilePath = "./examples/straight.maz.txt";
        // Setup objects that will be used across multiple test methods
        try {
            loader = new MazeLoader(testMazeFilePath);
            maze = new Maze(loader);
            rightHandExplorer = new RightHandAlgorithm();
            pathVerification = new PathVerification(maze);
        } catch (Exception e) {
            fail("Test setup failed: " + e.getMessage());
        }
        
    }

    
    @Test
    public void testFindPath() {
        assertTrue(pathVerification.verifyPath("4F")); //for straight maze 4F is correct path
    }

    @Test 
    public void testRightHandAlgorithm() { 
        assertEquals("FFFF", rightHandExplorer.findPath(maze)); //for straight maze 4F is correct path
    }

    @Test
    public void testCanonicalToFactoredPahth() { 
        PathFormat pathFormat = new PathFormat("FFFF");
        assertEquals("4F", pathFormat.pathFactored());
    }

    @Test 
    public void testFactoredToCanonicalPath() { 
        PathFormat pathFormat = new PathFormat("4F");
        assertEquals("FFFF", pathFormat.pathCanonical());
    }

    @Test 
    public void testMazeRows() { 
        assertEquals(5, maze.getRow());
    }

    @Test 
    public void testMazeCols() { 
        MazeMovement mazeMovement = new MazeMovement(maze);
        assertFalse(mazeMovement.isValidPosition(5, 6)); //for straight maze its 5x5 
    }

    @Test 
    public void testRightTurnDirection() { 
        MazeMovement mazeMovement = new MazeMovement(maze);
        assertEquals("SOUTH", mazeMovement.getNextDirection("EAST"));
    }

    @Test 
    public void testLeftTurnDirection() { 
        MazeMovement mazeMovement = new MazeMovement(maze);
        assertNotEquals("SOUTH", mazeMovement.getTurnLeftDirection("EAST"));
    }

    @Test
    void testInputFileFlag() throws ParseException, org.apache.commons.cli.ParseException {
        // Test with input file flag
        String[] args = {"-i", "./examples/small.maze.txt"};
        InputFlags flags = new InputFlags(args);
        //InputFlags flags = new InputFlags.Builder()
    //.parseArgs(args)
    //.build();
        
        assertTrue(flags.hasInputFile(), "Should detect input file flag");
        assertEquals("./examples/small.maze.txt", flags.getInputFile(), "Should return correct input file");
    }

    @Test
    void testPathFlag() throws ParseException, org.apache.commons.cli.ParseException {
        // Test with input file flag
        String[] args = {"-p", "4F" };
        InputFlags flags = new InputFlags(args);
        //InputFlags flags = new InputFlags.Builder()
    //.parseArgs(args)
    //.build();
        
        assertTrue(flags.hasPath(), "Should detect path flag");
        assertEquals("4F", flags.getPath(), "Should return correct input path");
    }

}
