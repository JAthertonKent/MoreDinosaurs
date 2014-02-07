package dinosaurs.model;

import lombok.Data;

@Data
public class Dinosaur {
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
