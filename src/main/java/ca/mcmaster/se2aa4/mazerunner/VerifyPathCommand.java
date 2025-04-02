package ca.mcmaster.se2aa4.mazerunner;

public class VerifyPathCommand implements MazeCommand {
    private Maze maze;
    private String path;
    private boolean verificationResult;
    private PathVerification pathVerification;

    public VerifyPathCommand(Maze maze, String path) {
        this.maze = maze;
        this.path = path;
        this.pathVerification = new PathVerification(maze);
    }

    @Override
    public void execute() {
        verificationResult = pathVerification.verifyPath(path);
        System.out.println(verificationResult ? "Correct path" : "Incorrect path");
    }

    public boolean getVerificationResult() {
        return verificationResult;
    }
}