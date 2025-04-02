package ca.mcmaster.se2aa4.mazerunner;

public class FindPathCommand implements MazeCommand{
    private Maze maze;
    private Explorer explorer;
    private String generatedPath;

    public FindPathCommand(Maze maze, Explorer explorer) {
        this.maze = maze;
        this.explorer = explorer;
    }

    @Override
    public void execute() {
        generatedPath = explorer.findPath(maze);
        PathFormat format = new PathFormat(generatedPath);
        generatedPath = format.pathFactored();
        System.out.println(generatedPath);
    }

    public String getPath() {
        return generatedPath;
    }
    
}
