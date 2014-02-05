package dinosaurs.command;

import dinosaurs.dal.DinosaurRepository;
import dinosaurs.factory.DinosaurFactory;
import dinosaurs.io.Console;
import dinosaurs.model.Dinosaur;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddDinosaurCommand implements Command {

    private final Console console;
    private final DinosaurRepository dinoRepo;

    @Override
    public String getName() {
        return "Add Dinosaur";
    }

    @Override
    public void execute() {
        String input = console.prompt("Enter the name of your dinosaur:");
        dinoRepo.addDinosaur(DinosaurFactory.create(input));
    }
}
