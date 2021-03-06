package dinosaurs.command;

import dinosaurs.dal.DinosaurRepository;
import dinosaurs.factory.DinosaurFactory;
import dinosaurs.io.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddDinosaurCommandTest {

    @Mock
    private Console console;
    @Mock
    private DinosaurRepository dinoRepo;

    @InjectMocks
    private AddDinosaurCommand underTest;

    @Test
    public void shouldDisplayName() {
        assertEquals(underTest.getName(), "Add Dinosaur");
    }

    @Test
    public void shouldAddADinosaur() {
        String dinoName = "Triceratops";
        when(console.prompt(anyString())).thenReturn(dinoName);
        underTest.execute();
        verify(dinoRepo).addDinosaur(DinosaurFactory.create(dinoName));
    }

}
