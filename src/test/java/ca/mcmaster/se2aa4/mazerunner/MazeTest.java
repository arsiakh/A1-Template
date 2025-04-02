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
    private MazeLoader loader2;
    private Maze maze;
    private Maze maze2;
    private Explorer rightHandExplorer;
    private PathVerification pathVerification;
    private PathVerification pathVerification2;

    @BeforeEach
    void setUp() {
        // Create a standard initializer with default parameters
        String testMazeFilePath = "./examples/straight.maz.txt";
        String testMazeFilePath2 = "./examples/medium.maz.txt";
        // Setup objects that will be used across multiple test methods
        try {
            loader = new MazeLoader(testMazeFilePath);
            loader2 = new MazeLoader(testMazeFilePath2);
            maze = new Maze(loader);
            maze2 = new Maze(loader2);
            rightHandExplorer = new RightHandAlgorithm();
            pathVerification = new PathVerification(maze);
            pathVerification2 = new PathVerification(maze2);
        } catch (Exception e) {
            fail("Test setup failed: " + e.getMessage());
        }
        
    }

    
    @Test
    public void testFindPath() {
        assertTrue(pathVerification2.verifyPath("FR6F2L8FR2FR2F2L2FR2FR4FR2FL4FL2F2L2FR4FR2FL2FR2FR4FR2F2L2FL2FR2FR4FR2F2L2FL2FR2F2L2FR2FR2F2L4FR2FR2F2L4FR2FR2F2L4FR2FR2F2L2FR10FR2FR8F2L8FL2FR4FR2FR2F2L2FR2FR14F2L12FR2FR6F2L4FR2FR6FR2FL6F2L6FR2FR8F2L12FR2FR10F2L6FR2FR4F2L4FL2FR4FL2FR2FL2FR2FL2FR2FL4FR2FR2F2L4FR2FR6FR2F2L2FR2FR4F2L2FR2FR4F2L4FR2FR2F2L2FR2FR4FR2FL2F2L2FR2FR6FL2FR8F2L8FR2FR10FR4FR2F2L2FR2F2L2FR2FR2FL4FR2F2L4F2L2FR4FR2FR2F2L4FR2FR6F2L6FR4FR2FR2FL2F2L2FR4FR2FR2F2L2FR2FR4F2L4FL4FR2FR4F2L2FR2F2L2FR2FR2F2L6FR2FR8FR6FR2F2L2FL2FRF")); //for straight maze 4F is correct path
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
        
        
        assertTrue(flags.hasInputFile(), "Should detect input file flag");
        assertEquals("./examples/small.maze.txt", flags.getInputFile(), "Should return correct input file");
    }

    @Test
    void testPathFlag() throws ParseException, org.apache.commons.cli.ParseException {
        // Test with input file flag
        String[] args = {"-p", "4F" };
        InputFlags flags = new InputFlags(args);
        
        
        assertTrue(flags.hasPath(), "Should detect path flag");
        assertEquals("4F", flags.getPath(), "Should return correct input path");
    }

}
