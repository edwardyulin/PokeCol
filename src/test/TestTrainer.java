import model.Audience;
import model.Pokemon;
import model.Trainer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTrainer {
    private Trainer trainer;
    private List<Pokemon> pokemonList;
    private Pokemon pokemon;
    private ArrayList<Integer> stats;
    private Audience aud1;
    private Audience aud2;
    private List<Audience> listOfAud;

    @BeforeEach
    void setUp() {
        trainer = new Trainer("Trainer");
        pokemonList = new ArrayList<>();
        stats = new ArrayList<>();
        stats.add(15);
        stats.add(15);
        stats.add(15);
        pokemon = new Pokemon("Pokemon", stats);
        aud1 = new Audience("Professor Oak");
        aud2 = new Audience("A random kid");
        listOfAud = new ArrayList<>();

    }

    @Test
    void testDisplay() {
        assertEquals("Trainer", trainer.display("Trainer"));
    }

    @Test
    void testGetEmptyList() {
        assertEquals(pokemonList, trainer.getList());
    }

    @Test
    void testGetListWithPokemon() {
        trainer.addPokemon(pokemon);
        pokemonList.add(pokemon);
        assertEquals(pokemonList, trainer.getList());
    }

    @Test
    void testGetListWithRepeatedPokemon() {
        trainer.addPokemon(pokemon);
        trainer.addPokemon(pokemon);
        pokemonList.add(pokemon);
        assertEquals(pokemonList, trainer.getList());
    }

    @Test
    void testAddOneObserver() {
        trainer.addObserver(aud1);
        listOfAud.add(aud1);
        assertEquals(listOfAud,trainer.getObserver());
    }

    @Test
    void testAddOneRepeatedObserver() {
        trainer.addObserver(aud1);
        trainer.addObserver(aud1);
        listOfAud.add(aud1);
        assertEquals(listOfAud,trainer.getObserver());
    }

    @Test
    void testAddTwoObserver() {
        trainer.addObserver(aud1);
        trainer.addObserver(aud2);
        listOfAud.add(aud1);
        listOfAud.add(aud2);
        assertEquals(listOfAud, trainer.getObserver());
    }

    @Test
    void testAddTwoThenRemoveOneObserver() {
        trainer.addObserver(aud1);
        trainer.addObserver(aud2);
        trainer.removeObserver(aud1);
        listOfAud.add(aud2);
        assertEquals(listOfAud, trainer.getObserver());
    }

    @Test
    void testRemoveNoObserver() {
        trainer.addObserver(aud2);
        trainer.removeObserver(aud1);
        listOfAud.add(aud2);
        assertEquals(listOfAud, trainer.getObserver());
    }
}
