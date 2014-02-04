package dinosaurs;

import dinosaurs.io.Console;
import lombok.AllArgsConstructor;
import dinosaurs.command.Command;

import java.util.List;

@AllArgsConstructor
public class Menu {
    private Console console;
    private List<Command> options;

    public void display() {
        console.print("Please choose from the following options:");

        for (Command command: options) {
            console.print(command.getName());
        }
    }

    public int prompt() {
        int input;
        do {
            input = console.ask();
        } while (isInvalidOption(input));
        return input - 1;
    }

    private boolean isInvalidOption(int option) {
        return option < 1 || option > options.size();
    }

    public void execute(int mappedInput) {
        options.get(mappedInput).execute();
    }
}
