package model;


import java.util.ArrayList;
import java.util.List;

public class Trainer extends Attractions {
    private List<Pokemon> pokemonList;

    public Trainer(String name) {
        super(name);
        pokemonList = new ArrayList<>();
    }

    @Override
    //EFFECTS: overridden display method that calls super to display the name
    public String display(String name) {
        super.display(name);
        return "Trainer";
    }

    //MODIFIES: this
    //EFFECTS: if the trainer not yet have the Pokemon, then add to his/her list and notify observer
    public void addPokemon(Pokemon p) {
        if (!(pokemonList.contains(p))) {
            pokemonList.add(p);
            notifyObserver(p);
        }
    }

    //EFFECTS: return the Pokemon list that the trainer currently has
    public List<Pokemon> getList() {
        return pokemonList;
    }
}
