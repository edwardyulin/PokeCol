package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Attractions {
    protected String name;
    private List<TrainersObserver> trainersObserver;

    public Attractions(String name) {
        this.name = name;
        trainersObserver = new ArrayList<>();
    }

    //EFFECTS: call the print method in Map to print text in the UI console and return "Attraction"
    public String display(String name) {
        Map.print(name, this.name);
        return "Attraction";
    }

    //EFFECTS: if the trainersObserver is not already in the list of trainersObserver then add it in
    public void addObserver(TrainersObserver o) {
        if (!(trainersObserver.contains(o))) {
            trainersObserver.add(o);
        }
    }

    //EFFECTS: if the trainersObserver is in the list of trainerObserver then remove it
    public void removeObserver(TrainersObserver o) {
        if (trainersObserver.contains(o)) {
            trainersObserver.remove(o);
        }
    }

    public List<TrainersObserver> getObserver() {
        return trainersObserver;
    }

    public void notifyObserver(Pokemon p) {
        for (TrainersObserver o: trainersObserver) {
            o.update(p);
        }
    }
}
