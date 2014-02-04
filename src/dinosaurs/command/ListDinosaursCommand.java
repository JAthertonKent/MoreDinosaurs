package dinosaurs.command;

import dinosaurs.io.Console;
import dinosaurs.dal.DinosaurRepository;
import dinosaurs.model.Dinosaur;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class ListDinosaursCommand implements Command {

    private final DinosaurRepository dinosaurRepository;
    private final Console console;

    @Override
    public String getName() {
        return "List Dinosaurs";
    }

    @Override
    public void execute() {
        final List<Dinosaur> allDinosaurs = dinosaurRepository.getAllDinosaurs();
        if (allDinosaurs.size() == 0){
            console.print("No Dinosaurs");
        }
        for (final Dinosaur dinosaur : allDinosaurs) {
            console.print(dinosaur.toString());
        }
    }
}
