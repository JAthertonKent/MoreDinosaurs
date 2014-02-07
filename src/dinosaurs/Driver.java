package dinosaurs;

import static com.google.common.collect.Lists.newArrayList;

import dinosaurs.command.AddDinosaurCommand;
import dinosaurs.command.Command;
import dinosaurs.command.ListDinosaursCommand;
import dinosaurs.command.SearchDinosaurCommand;
import dinosaurs.dal.DinosaurRepository;
import dinosaurs.dal.InMemoryDinosaurRepository;
import dinosaurs.io.Console;

import java.util.List;

public class Driver {
    public static void main(String[] args){
        Console console = new Console(System.in, System.out);
        DinosaurRepository dinoRepo = new InMemoryDinosaurRepository();
        AddDinosaurCommand addc = new AddDinosaurCommand(console, dinoRepo);
        ListDinosaursCommand listc = new ListDinosaursCommand(console, dinoRepo);
        SearchDinosaurCommand searchc = new SearchDinosaurCommand(console, dinoRepo);
        List<Command> commands = newArrayList(listc, addc, searchc);

        Menu menu = new Menu(console, commands);
        int choice;
        while (true) {
            menu.displayOptions();
            choice = menu.promptForOptionNumber();
            menu.execute(choice);
        }

    }
}
