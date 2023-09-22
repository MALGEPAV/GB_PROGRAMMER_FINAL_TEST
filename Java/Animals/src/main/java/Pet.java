import java.util.Set;

public abstract class Pet {
    private final String name;
    private Set<String> commands;

    public Pet(String name, Set<String> commands) {
        this.name = name;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public Set<String> getCommands() {
        return commands;
    }

    public String showCommands() {
        return commands.toString();
    }

    public void learnNewCommand(String newCommand) {
        commands.add(newCommand);
    }

    @Override
    public String toString() {
        return String.format("NAME: %s; COMMANDS: %s", name, commands);
    }
}
