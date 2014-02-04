package dinosaurs.command;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddDinosaurCommandTest {

    AddDinosaurCommand underTest = new AddDinosaurCommand();

    @Test
    public void shouldDisplayName() {
        assertEquals(underTest.getName(), "Add Dinosaur");
    }
}
