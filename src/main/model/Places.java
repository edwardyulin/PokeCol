package model;

import java.util.ArrayList;
import java.util.List;

public class Places extends Attractions {
    private List<Attractions> children;

    public Places(String name) {
        super(name);
        children = new ArrayList<>();
    }

    //EFFECTS: add appropriate children (places or trainers) to the parent node
    public void add(Attractions a) {
        children.add(a);
    }

   //EFFECTS: getter function to get all children in the parent node
    public List<Attractions> getChildren() {
        return children;
    }

    @Override
    //EFFECTS: iterate through all the children and display them in the console (parent included) and return "Place"
    public String display(String name) {
        super.display(name);
        for (Attractions a: children) {
            a.display(this.name);
        }
        return "Place";
    }
}
