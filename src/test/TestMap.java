import model.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMap {
    private Map map;

    @BeforeEach
    void setUp() {
        map = new Map();
    }

    @Test
    void testBattleBrock() {
        assertEquals("Battle", map.print("Location", "Brock"));
    }

    @Test
    void testBattleMisty() {
        assertEquals("Battle", map.print("Location", "Misty"));
    }

    @Test
    void testBattleTeamRocket() {
        assertEquals("Rocket", map.print("Location", "Jessie"));
        assertEquals("Rocket", map.print("Location", "James"));
    }
}
