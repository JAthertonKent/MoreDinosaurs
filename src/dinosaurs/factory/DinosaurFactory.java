package dinosaurs.factory;

import dinosaurs.model.Dinosaur;

public class DinosaurFactory {

    public static Dinosaur create(String dinoName) {
        return new Dinosaur(dinoName);
    }
}
