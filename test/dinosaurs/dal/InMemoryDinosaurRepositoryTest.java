package dinosaurs.dal;

import com.google.common.collect.Maps;
import dinosaurs.factory.DinosaurFactory;
import dinosaurs.model.Dinosaur;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InMemoryDinosaurRepositoryTest {

    public static final String DINO_NAME = "ted";
    public static final Dinosaur DINO = DinosaurFactory.create(DINO_NAME);
    private Map<String, Dinosaur> dinoMap;

    private InMemoryDinosaurRepository underTest;

    @Before
    public void setup() {
        dinoMap = Maps.newHashMap();
        dinoMap.put(DINO_NAME, DINO);

        underTest = new InMemoryDinosaurRepository(dinoMap);
    }

    @Test
    public void should() {
        List<Dinosaur> dinoList = underTest.getAllDinosaurs();
        assertTrue(dinoList.contains(DINO));
        assertEquals(dinoList.size(), 1);
    }

}
