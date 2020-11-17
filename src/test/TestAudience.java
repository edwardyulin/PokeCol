import model.Audience;
import model.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAudience {
    private Audience audience;
    private Pokemon pokemon;
    private ArrayList<Integer> stats;

    @BeforeEach
    void sepUp() {
        audience = new Audience("Audience");
        stats = new ArrayList<>();
        stats.add(15);
        stats.add(15);
        stats.add(15);
        pokemon = new Pokemon("Pokemon", stats);
    }

    @Test
    void testUpdate() {
        assertEquals("Updated", audience.update(pokemon));
    }
}
