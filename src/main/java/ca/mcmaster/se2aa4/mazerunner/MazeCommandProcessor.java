package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class MazeCommandProcessor {
    private List<MazeCommand> commandHistory = new ArrayList<>();

    public void executeCommand(MazeCommand command) {
        command.execute();
        commandHistory.add(command);
    }

    public List<MazeCommand> getCommandHistory() {
        return new ArrayList<>(commandHistory);
    }
}
