package model;

import java.util.ArrayList;
import java.util.List;

public class TrainingList {
    private String name;
    private int capacity;
    private List<Pokemon> pokeInTraining;

    public TrainingList(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        pokeInTraining = new ArrayList<>();
    }

    //EFFECTS: get name of the training list
    public String getName() {
        return name;
    }

    //EFFECTS: get the capacity of the training list
    public int getCapacity() {
        return capacity;
    }

    //EFFECTS: get the list of Pokemon currently in training
    public List<Pokemon> getPokemonInTraining() {
        return pokeInTraining;
    }

    //EFFECTS: check if the training list is full, true if it is full, false otherwise
    public boolean isFull() {
        if (capacity == pokeInTraining.size()) {
            return true;
        }
        return false;
    }

    //MODIFIES: this.pokeInTraining
    //EFFECTS: if the training list not yet include the inputted Pokemon, then add the Pokemon to the training list
    //         also make a recursive call to add training list to Pokemon
    public void addPokemon(Pokemon pokemon) {
        if (!pokeInTraining.contains(pokemon)) {
            pokeInTraining.add(pokemon);
            pokemon.addToTrainingList(this);
        }
    }

    //MODIFIES: this.pokeInTraining
    //EFFECTS: if the training list contains the inputted Pokemon, then remove it from the list
    //         also make a recursive call to remove training list from Pokemon
    public void removePokemon(Pokemon pokemon) {
        if (pokeInTraining.contains(pokemon)) {
            pokeInTraining.remove(pokemon);
            pokemon.removeFromTrainingList();
        }
    }
}
