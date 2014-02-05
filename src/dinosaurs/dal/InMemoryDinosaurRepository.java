package dinosaurs.dal;

import dinosaurs.model.Dinosaur;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;

public class InMemoryDinosaurRepository implements DinosaurRepository {

    private final Map<String, Dinosaur> dinosaurMap;

    public InMemoryDinosaurRepository(Map<String, Dinosaur> dinoMap) {
        this.dinosaurMap = dinoMap;
    }

    @Override
    public List<Dinosaur> getAllDinosaurs() {
        return newArrayList(dinosaurMap.values());
    }

    @Override
    public List<Dinosaur> searchDinosaurByName(String dino) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addDinosaur(Dinosaur dino) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeDinosaurByName(String dinoName) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
