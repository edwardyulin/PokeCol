import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlaces {
    private List<Attractions> children;
    private Places place;
    private Places subPlace;
    private Trainer trainer;

    @BeforeEach
    void setUp() {
        children = new ArrayList<>();
        place = new Places("Place");
        subPlace = new Places("Child");
        trainer = new Trainer("Trainer");
        children.add(subPlace);
        children.add(trainer);

    }

    @Test
    void testAdd() {
        place.add(subPlace);
        place.add(trainer);
        assertEquals(children, place.getChildren());
    }

    @Test
    void testDisplay() {
        place.add(subPlace);
        place.add(trainer);
        place.display("Main");
        assertEquals("Place", place.display("Main"));
    }
}
