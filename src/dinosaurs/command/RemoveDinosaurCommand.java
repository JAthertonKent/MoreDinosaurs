package dinosaurs.command;

import dinosaurs.dal.DinosaurRepository;
import dinosaurs.io.Console;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RemoveDinosaurCommand implements Command {

    private final Console console;
    private DinosaurRepository dinosaurRepository;

    @Getter
    private final String name = "Remove Dinosaur";

    @Override
    public void execute() {
        final String input = console.prompt("Enter the name of the dinosaur to be removed:");
        dinosaurRepository.removeDinosaurByName(input);
    }
}
