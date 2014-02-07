package dinosaurs.command;

import dinosaurs.dal.DinosaurRepository;
import dinosaurs.io.Console;
import dinosaurs.model.Dinosaur;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchDinosaurCommandTest {

    private static final String DINO_NAME = "Velociraptor";
    private static final Dinosaur DINO_1 = new Dinosaur(DINO_NAME);
    private static final Dinosaur DINO_2 = new Dinosaur(DINO_NAME);

    @Mock
    private Console console;
    @Mock
    private DinosaurRepository dinoRepo;

    @InjectMocks
    private SearchDinosaurCommand underTest;

    @Before
    public void setup() {
        when(console.prompt(anyString())).thenReturn(DINO_NAME);
        List<Dinosaur> dinosaurList = Arrays.asList(DINO_1);
        when(dinoRepo.searchDinosaurByName(DINO_NAME)).thenReturn(dinosaurList);
    }

    @Test
    public void shouldDisplayName() {
        assertEquals(underTest.getName(), "Search Dinosaur");
    }

    @Test
    public void shouldPromptAndSearchForInput() {
        List<Dinosaur> dinosaurList = Arrays.asList(DINO_1);
        when(dinoRepo.searchDinosaurByName(DINO_NAME)).thenReturn(dinosaurList);
        underTest.execute();
        verify(dinoRepo).searchDinosaurByName(DINO_NAME);
    }

    @Test
    public void shouldReturnDinoIfFound() {
        underTest.execute();
        List<Dinosaur> dinosaurList = Arrays.asList(DINO_1);
        when(dinoRepo.searchDinosaurByName(DINO_NAME)).thenReturn(dinosaurList);
        verify(console).print(DINO_1.toString());
    }

    @Test
    public void shouldReturnMessageIfDinoNotFound() {
        when(dinoRepo.searchDinosaurByName(DINO_NAME)).thenReturn(new ArrayList<Dinosaur>());
        underTest.execute();
        verify(console).print("Sorry no dinosaur found by name \"" + DINO_NAME + "\"");
    }

    @Test
    public void shouldReturnAllDinosIfFound() {
        when(dinoRepo.searchDinosaurByName(DINO_NAME)).thenReturn(Arrays.asList(DINO_1, DINO_2));
        underTest.execute();
        verify(console).print(DINO_1.toString() + ", " + DINO_2.toString());
    }
}
