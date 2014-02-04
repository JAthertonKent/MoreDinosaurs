package dinosaurs.command;

import dinosaurs.io.Console;
import dinosaurs.dal.DinosaurRepository;
import dinosaurs.model.Dinosaur;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.util.List;

@AllArgsConstructor
public class SearchDinosaurCommand implements Command {

    private final Console console;
    private DinosaurRepository dinosaurRepository;

    @Override

    public String getName() {
        return "Search Dinosaur";
    }

    @Override
    public void execute() {
        final String query = console.prompt("Please type the name of the dinosaur you would like: ");
        final List<Dinosaur> dinoList = dinosaurRepository.searchDinosaurByName(query);
        final String message;
        if (dinoList.isEmpty()) {
            message = "Sorry no dinosaur found by name " + query;
        } else {
            message = StringUtils.join(dinoList, ", ");
        }
        console.print(message);
    }

}
