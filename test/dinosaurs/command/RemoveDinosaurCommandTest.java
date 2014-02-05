package dinosaurs.command;

import dinosaurs.dal.DinosaurRepository;
import dinosaurs.io.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RemoveDinosaurCommandTest {

    public static final String DINO_NAME = "T-Rex";

    @Mock
    private Console console;
    @Mock
    private DinosaurRepository dinoRepo;

    @InjectMocks
    RemoveDinosaurCommand underTest;

    @Test
    public void shouldDisplayName() {
        assertEquals(underTest.getName(), "Remove Dinosaur");
    }

    @Test
    public void shouldRemoveDinosaurByName() {
        Mockito.when(console.prompt(anyString())).thenReturn(DINO_NAME);
        underTest.execute();
        verify(dinoRepo).removeDinosaurByName(DINO_NAME);
    }
}
