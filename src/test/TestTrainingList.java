import model.Pokemon;
import model.TrainingList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestTrainingList {
    private TrainingList trainingList;
    private Pokemon pokemon;
    private Pokemon pokemon2;
    private ArrayList<Pokemon> pokeList;
    private ArrayList<Pokemon> pokeList2;
    private ArrayList<Pokemon> pokeList3;
    private ArrayList<Integer> stat1;
    private ArrayList<Integer> stat2;

    @BeforeEach
    void setUp() {
        stat1 = new ArrayList<>();
        stat1.add(15);
        stat1.add(15);
        stat1.add(15);
        stat2 = new ArrayList<>();
        stat2.add(1);
        stat2.add(1);
        stat2.add(1);
        pokemon = new Pokemon("Ditto", stat1);
        pokemon2 = new Pokemon("Ditto", stat2);
        trainingList = new TrainingList("TrainDitto", 2);
        pokeList = new ArrayList<>(Arrays.asList(pokemon, pokemon2));
        pokeList2 = new ArrayList<>(Arrays.asList());
        pokeList3 = new ArrayList<>(Arrays.asList(pokemon2));
    }

    @Test
    void testGetName() {
        assertEquals("TrainDitto", trainingList.getName());
    }

    @Test
    void testGetCapcity() {
        assertEquals(2, trainingList.getCapacity());
    }

    @Test
    void testIsNotFull() {
        trainingList.addPokemon(pokemon);
        assertFalse(trainingList.isFull());
    }

    @Test
    void testIsFull() {
        trainingList.addPokemon(pokemon);
        trainingList.addPokemon(pokemon2);
        assertTrue(trainingList.isFull());
    }

    @Test
    void testGetPokemonInTraining() {
        trainingList.addPokemon(pokemon);
        trainingList.addPokemon(pokemon2);
        assertEquals(pokeList, trainingList.getPokemonInTraining());
    }

    @Test
    void testRemoveTwoPokemon() {
        trainingList.addPokemon(pokemon);
        trainingList.addPokemon(pokemon2);
        assertEquals(pokeList, trainingList.getPokemonInTraining());
        trainingList.removePokemon(pokemon);
        trainingList.removePokemon(pokemon2);
        assertFalse(trainingList.isFull());
        assertEquals(pokeList2,trainingList.getPokemonInTraining());
    }

    @Test
    void testRemoveOnePokemon() {
        trainingList.addPokemon(pokemon);
        trainingList.addPokemon(pokemon2);
        assertEquals(pokeList, trainingList.getPokemonInTraining());
        trainingList.removePokemon(pokemon);
        assertFalse(trainingList.isFull());
        assertEquals(pokeList3,trainingList.getPokemonInTraining());
    }
}
