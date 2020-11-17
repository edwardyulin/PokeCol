import model.Pokemon;
import model.TrainingList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestPokemon {
    private Pokemon pokemon;
    private TrainingList trainingList;
    private ArrayList<Integer> stats;
    private Pokemon samePokemon;
    private Pokemon differentNamePokemon;

    @BeforeEach
    void setUp() {
        stats = new ArrayList<>();
        stats.add(15);
        stats.add(15);
        stats.add(15);
        pokemon = new Pokemon("Ditto", stats);
        samePokemon = new Pokemon("Ditto", stats);
        differentNamePokemon = new Pokemon("Pikachu", stats);
        trainingList = new TrainingList("TrainDitto", 2);
    }

    @Test
    void testGetAtt() {
        assertEquals(15, pokemon.getAtt());
    }

    @Test
    void testGetDef() {
        assertEquals(15, pokemon.getDef());
    }

    @Test
    void testGetSta() {
        assertEquals(15, pokemon.getSta());
    }

    @Test
    void testGetName() {
        assertEquals("Ditto", pokemon.getName());
    }

    @Test
    void testSetAtt() {
        pokemon.setAtt(5);
        assertEquals(5, pokemon.getAtt());
    }

    @Test
    void testSetDef() {
        pokemon.setDef(10);
        assertEquals(10, pokemon.getDef());
    }

    @Test
    void testSetSta() {
        pokemon.setSta(5);
        assertEquals(5, pokemon.getSta());
    }

    @Test
    void testIsNotInTraining() {
        assertFalse(pokemon.isInTraining());
    }

    @Test
    void testIsInTraining() {
        assertFalse(pokemon.isInTraining());
        pokemon.addToTrainingList(trainingList);
        assertTrue(pokemon.isInTraining());
    }

    @Test
    void testAddToThenRemovedFromTrainingList() {
        pokemon.addToTrainingList(trainingList);
        assertTrue(pokemon.isInTraining());
        pokemon.removeFromTrainingList();
        assertFalse(pokemon.isInTraining());
    }

    @Test
    void testEquals() {
        assertTrue(pokemon.equals(samePokemon));
    }

    @Test void testNotEquals() {
        assertFalse(pokemon.equals(differentNamePokemon));
    }
}
