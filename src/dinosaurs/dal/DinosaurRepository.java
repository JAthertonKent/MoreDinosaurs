package dinosaurs.dal;

import dinosaurs.model.Dinosaur;

import java.util.List;

public interface DinosaurRepository {
    public List<Dinosaur> getAllDinosaurs();

    public List<Dinosaur> searchDinosaurByName(String dino);

    public void addDinosaur(Dinosaur dino);

    public void removeDinosaurByName(String dinoName);
}
