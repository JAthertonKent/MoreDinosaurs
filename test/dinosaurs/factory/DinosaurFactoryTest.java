package dinosaurs.factory;

import dinosaurs.model.Dinosaur;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DinosaurFactoryTest {

    @Test
    public void shouldCreateDinosaurWithName() {
        Dinosaur dino = DinosaurFactory.create("Triceratops");
        assertEquals(dino.getName(), "Triceratops");
    }
}
