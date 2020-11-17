import model.Battle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBattle {

    @Test
    void testToBattlefield() {
        assertEquals("Misty", Battle.toBattlefield("Misty"));
        assertEquals("Brock", Battle.toBattlefield("Brock"));
    }

    @Test
    void testFightTeamRocket() {
        assertEquals("Rocket", Battle.fightTeamRocket("James"));
    }
}
