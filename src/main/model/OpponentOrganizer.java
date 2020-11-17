package model;

import exceptions.OptionException;
import ui.PokemonOrganizer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OpponentOrganizer extends PokemonOrganizer {

    //EFFECTS: initiates a collection and the input of name from the user, proceed to gameInterface

    public OpponentOrganizer(ArrayList<String> collection, JPanel panel) {
        panel.setBackground(Color.BLUE);

        greetText(panel);
        selectionText(collection, panel);
    }


    @Override
    //EFFECTS: return the string "your opponent's" when called from the superclass
    public String getTrainer() {
        return "your opponent's";
    }

    @Override
    //EFFECTS: return the string "Your opponent" when called from the superclass
    public String getTrainerName() {
        return "Your opponent";
    }

}