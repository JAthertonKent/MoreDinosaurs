package dinosaurs.command;

import dinosaurs.io.Console;
import dinosaurs.dal.DinosaurRepository;
import dinosaurs.model.Dinosaur;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ListDinosaursCommandTest {

    @Mock
    private Console console;
    @Mock
    private DinosaurRepository dinoRepo;
    @Mock
    private Dinosaur dino;

    private ListDinosaursCommand underTest;
    private List<Dinosaur> dinoList;

    @Before
    public void setup() {
        underTest = new ListDinosaursCommand(dinoRepo, console);
    }

    @Test
    public void shouldDisplayName() {
        assertEquals(underTest.getName(), "List Dinosaurs");
    }

    @Test
    public void shouldListAllDinos() {
        dinoList = Arrays.asList(dino, dino, dino);
        when(dinoRepo.getAllDinosaurs()).thenReturn(dinoList);
        underTest.execute();
        verify(console, times(dinoList.size())).print(dino.toString());
    }

    @Test
    public void shouldReturnMessageIfThereAreNoDinos() {
        underTest.execute();
        verify(console).print("No Dinosaurs");
    }
}
