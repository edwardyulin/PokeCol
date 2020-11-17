package model;

import java.util.ArrayList;
import java.util.Objects;

public class Pokemon {
    private ArrayList<Integer> stats;
    private String name;
    private TrainingList trainingList;

    public Pokemon(String name, ArrayList<Integer> stats) {
        this.stats = stats;
        this.name = name;
    }

    //EFFECTS: getter function for Pokemon's attack
    public Integer getAtt() {
        return stats.get(0);
    }

    //EFFECTS: getter function for Pokemon's defense
    public Integer getDef() {
        return stats.get(1);
    }

    //EFFECTS: getter function for Pokemon's stamina
    public Integer getSta() {
        return stats.get(2);
    }

    //EFFECTS: getter function for Pokemon's name
    public String getName() {
        return name;
    }


    //MODIFIES: this.stats
    //EFFECTS: set Pokemon's attack as the inputted value
    public int setAtt(int att) {
        stats.set(0, att);
        return att;
    }

    //MODIFIES: this.stats
    //EFFECTS: set Pokemon's defense as the inputted value
    public int setDef(int def) {
        stats.set(1, def);
        return def;
    }

    //MODIFIES: this.stats
    //EFFECTS: set Pokemon's stamina as the inputted value
    public int setSta(int sta) {
        stats.set(2, sta);
        return sta;
    }

    //EFFECTS: getter function for all the Pokemon in training
    public TrainingList getTrainingList() {
        return trainingList;
    }

    //EFFECTS: get the training status for a Pokemon, in Boolean
    public boolean isInTraining() {
        if (!(getTrainingList() == null)) {
            return true;
        }
        return false;
    }

    //MODIFIES: this.trainingList, trainingList
    //EFFECTS: if the Pokemon is not already in the list, then add it to the list
    public void addToTrainingList(TrainingList trainingList) {
        if (!isInTraining()) {
            this.trainingList = trainingList;
            trainingList.addPokemon(this);
        }
    }

    //MODIFIES: this.trainingList
    //EFFECTS: if the Pokemon is in the list, the remove it from the list
    public void removeFromTrainingList() {
        if (isInTraining()) {
            trainingList.removePokemon(this);
            this.trainingList = null;
        }
    }

    @Override
    //EFFECTS: overridden equals method to check if two Pokemon's are equal and return true if equal, false otherwise
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pokemon)) {
            return false;
        }
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(stats, pokemon.stats)
                && Objects.equals(getName(), pokemon.getName());
    }

    @Override
    //EFFECTS: hashCode method return stats and name in the has format for Pokemon
    public int hashCode() {
        return Objects.hash(stats, getName());
    }
}
