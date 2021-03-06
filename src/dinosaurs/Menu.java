package dinosaurs;

import dinosaurs.io.Console;
import lombok.AllArgsConstructor;
import dinosaurs.command.Command;

import java.util.List;

@AllArgsConstructor
public class Menu {
    private Console console;
    private List<Command> options;

    public void displayOptions() {
        //console.print("Please choose from the following options:");

        int index = 1;
        for (Command command: options) {
            console.print(index++ + ". " + command.getName());
        }
    }

    public int promptForOptionNumber() {
        int input;
        input = console.ask();
        while(isInvalidOption(input)){
            console.print("Index out of bounds.");
            input = console.ask();
        }
        return input - 1;
    }

    private boolean isInvalidOption(int option) {
        return option < 1 || option > options.size();
    }

    public void execute(int mappedInput) {
        options.get(mappedInput).execute();
    }
}
