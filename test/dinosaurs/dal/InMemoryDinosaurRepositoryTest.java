package dinosaurs.dal;

import com.google.common.collect.Maps;
import dinosaurs.model.Dinosaur;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static dinosaurs.factory.DinosaurFactory.create;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class InMemoryDinosaurRepositoryTest {

    public static final String DINO_NAME = "ted";
    public static final String DINO_NAME2 = "stephen";
    public static final Dinosaur DINO = create(DINO_NAME);
    public static final Dinosaur DINO2 = create(DINO_NAME2);

    private Map<String, List<Dinosaur>> injectedMap;

    private InMemoryDinosaurRepository underTest;

    @Before
    public void setup() {
        injectedMap = Maps.newHashMap();
        injectedMap.put(DINO_NAME, newArrayList(DINO));
        injectedMap.put(DINO_NAME2, newArrayList(DINO2, create(DINO_NAME2)));

        underTest = new InMemoryDinosaurRepository(injectedMap);
    }

    @Test
    public void shouldGetAllDinosaursFromMap() {
        List<Dinosaur> dinoList = underTest.getAllDinosaurs();
        assertTrue(dinoList.contains(DINO));
        assertTrue(dinoList.contains(DINO2));
        assertEquals(dinoList.size(), 3);
    }

    @Test
    public void shouldSearchDinosaurByName() {
        List<Dinosaur> searchResults = underTest.searchDinosaurByName(DINO_NAME);
        assertTrue(searchResults.contains(DINO));
        assertEquals(searchResults.size(), 1);
    }

    @Test
    public void shouldSearchAndGetMultipleResults() {
        List<Dinosaur> searchResults = underTest.searchDinosaurByName(DINO_NAME2);
        assertTrue(searchResults.contains(DINO2));
        assertEquals(searchResults.size(), 2);
    }

    public void shouldAddDinosaurToMapWithNewName() {
        final String uniqueDinoName = "ThunderBolt";
        List<Dinosaur> searchResults = underTest.searchDinosaurByName(uniqueDinoName);
        assertEquals(searchResults.size(), 0);

        underTest.addDinosaur(create(uniqueDinoName));

        searchResults = underTest.searchDinosaurByName(uniqueDinoName);
        assertEquals(searchResults.size(), 1);
    }

    @Test
    public void shouldAddDinosaurToMapWithExistingName() {
        List<Dinosaur> searchResults = underTest.searchDinosaurByName(DINO_NAME2);
        assertEquals(searchResults.size(), 2);

        underTest.addDinosaur(create(DINO_NAME2));

        searchResults = underTest.searchDinosaurByName(DINO_NAME2);
        assertEquals(searchResults.size(), 3);
    }
}
