package dinosaurs.command;

import lombok.Getter;

public class AddDinosaurCommand implements Command {
    @Getter
    private final String name = "Add Dinosaur";

    @Override
    public void execute() {

    }
}
