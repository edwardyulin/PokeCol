package model;

import ui.PokemonOrganizer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyOrganizer extends PokemonOrganizer {

    //EFFECTS: initiates a collection and the input of name from the user, proceed to gameInterface
    public MyOrganizer(ArrayList<String> collection, JPanel panel) {
        panel.setBackground(Color.BLUE);

        greetText(panel);
        selectionText(collection, panel);
    }



    @Override
    //EFFECTS: return the string "your" when called from the superclass
    public String getTrainer() {
        return "your";
    }

    @Override
    //EFFECTS: return "You" when called from the superclass
    public String getTrainerName() {
        return "You";
    }

}