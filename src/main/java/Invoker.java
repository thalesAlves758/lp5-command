import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Command> executedCommands;

    public Invoker() {
        this.executedCommands = new ArrayList<>();
    }

    public void executeCommand(Command command){
        command.execute();
        executedCommands.add(command);
    }

    public void undoLastCommand() throws Exception {
        if(executedCommands.size() == 0) {
            throw new Exception("No executed command was found");
        }

        int lastIndex = executedCommands.size() - 1;
        Command command = executedCommands.get(lastIndex);
        command.undo();
        executedCommands.remove(command);
    }
}
