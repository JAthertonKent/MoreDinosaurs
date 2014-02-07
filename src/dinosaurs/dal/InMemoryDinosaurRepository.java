package dinosaurs.dal;

import com.google.common.collect.Maps;
import dinosaurs.model.Dinosaur;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;

public class InMemoryDinosaurRepository implements DinosaurRepository {

    private final Map<String, List<Dinosaur>> dinosaurMap;

    public InMemoryDinosaurRepository(Map<String, List<Dinosaur>> dinoMap) {
        this.dinosaurMap = dinoMap;
    }

    public InMemoryDinosaurRepository() {
        dinosaurMap = Maps.newHashMap();
    }

    @Override
    public List<Dinosaur> getAllDinosaurs() {
        final List<Dinosaur> allDinos = newArrayList();
        final Iterator<List<Dinosaur>> it = dinosaurMap.values().iterator();
        while (it.hasNext()) {
            List<Dinosaur> list = it.next();
            allDinos.addAll(list);
        }
        return allDinos;
    }

    @Override
    public List<Dinosaur> searchDinosaurByName(String dino) {
        if (dinosaurMap.containsKey(dino)) {
            return dinosaurMap.get(dino);
        } else {
            return newArrayList();
        }
    }

    @Override
    public void addDinosaur(Dinosaur dino) {
        final String key = dino.getName();
        if (dinosaurMap.containsKey(key)) {
            dinosaurMap.get(key).add(dino);
        } else {
            dinosaurMap.put(key, newArrayList(dino));
        }
    }

    @Override
    public void removeDinosaurByName(String dinoName) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
