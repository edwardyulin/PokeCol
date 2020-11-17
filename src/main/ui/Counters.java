package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Counters {
    private Map<String, ArrayList<String>> typeAndName = new HashMap();
    // not using for now, might need in the future
//    private ArrayList<String> waterType = typeAndName.get("Water");
//    private ArrayList<String> fireType = typeAndName.get("Fire");
//    private ArrayList<String> grassType = typeAndName.get("Grass");

    //EFFECTS: construct for the class Counters and proceed to counterSystem
    public Counters(String name, JPanel panel) {

        addType("Water");
        addType("Fire");
        addType("Grass");

        addPokemonToType("Water", "Squirtle");
        addPokemonToType("Water", "Totodile");
        addPokemonToType("Water", "Mudkip");
        addPokemonToType("Fire", "Charmander");
        addPokemonToType("Fire", "Cyndaquil");
        addPokemonToType("Fire", "Torchic");
        addPokemonToType("Grass", "Bulbasaur");
        addPokemonToType("Grass", "Chikorita");
        addPokemonToType("Grass", "Treecko");

        typeIdentifier(name, panel);
        JButton mainMenu = new JButton("Main Menu");
        panel.add(mainMenu);
        mainMenu.setBounds(300,530,150,50);
        mainMenu.setFont(new Font("Calibri", 1, 20));

        mainMenu.addActionListener(e -> {
            panel.removeAll();
            panel.invalidate();
            panel.repaint();
            IntroInterface.gameInterface(panel);
        });

    }


    //EFFECTS: identify the type of the Pokemon to generate appropriate behaviour
    public String typeIdentifier(String name, JPanel panel) {
        if (isWater(name, panel)) {
            return "Water";
        } else if (isFire(name, panel)) {
            return "Fire";
        } else if (isGrass(name, panel)) {
            return "Grass";
        }
        errorText(panel);
        return "";
    }

    //EFFECTS: show error text if Pokemon name is not valid in GUI
    private void errorText(JPanel panel) {
        JLabel error = new JLabel("That is an invalid name, please try again!");
        panel.add(error);
        error.setBounds(150,250,500,50);
        error.setFont(new Font("Calibri", 1, 20));
    }

    //EFFECT: check if Pokemon is Grass type, produce a Boolean value
    private Boolean isGrass(String name, JPanel panel) {
        for (String n: typeAndName.get("Grass")) {
            if (name.equals(n)) {
                grassText(name, panel);
                return true;
            }
        }
        return false;
    }

    //EFFECT: check if Pokemon is Fire type, produce a Boolean value
    private Boolean isFire(String name, JPanel panel) {
        for (String n: typeAndName.get("Fire")) {
            if (name.equals(n)) {
                fireText(name, panel);
                return true;
            }
        }
        return false;
    }

    //EFFECT: check if Pokemon is Water type, produce a Boolean value
    private Boolean isWater(String name, JPanel panel) {
        for (String n: typeAndName.get("Water")) {
            if (name.equals(n)) {
                waterText(name, panel);
                return true;
            }
        }
        return false;
    }

    //EFFECT: show text (name, type, counters, being countered by) if Pokemon is water type
    private void waterText(String name, JPanel panel) {
        panel.setBackground(new java.awt.Color(179, 236, 255));
        getWaterPic(panel);
        JLabel text1 = new JLabel(name + " is a Water type.");
        panel.add(text1);
        text1.setBounds(150,200,500,100);
        text1.setFont(new Font("Calibri", 1, 20));
        JLabel text2 = new JLabel(name + " is strong against Fire type Pokemon");
        panel.add(text2);
        text2.setBounds(150,230,600,100);
        text2.setFont(new Font("Calibri", 1, 20));
        JLabel text3 = new JLabel("and weak against Grass and Water type Pokemon");
        panel.add(text3);
        text3.setBounds(150,260,600,100);
        text3.setFont(new Font("Calibri", 1, 20));
        System.out.println("It is a Water type.");
        System.out.println(name + " is strong against Fire type Pokemon.");
        System.out.println("and weak against Grass and Water type Pokemon");
    }

    //EFFECTS:import a picture of Squirtle
    //        image from https://medium.com/@nelsonsmith_76141/the-squirtle-family-31f0230fd91e
    private void getWaterPic(JPanel panel) {
        ImageIcon squirtle = new ImageIcon("data/squirtle.jpg");
        JLabel label = new JLabel(squirtle);
        panel.add(label);
        label.setBounds(450,50,170,200);
    }

    //EFFECT: show text (name, type, counters, being countered by) if Pokemon is fire type
    public void fireText(String name, JPanel panel) {
        panel.setBackground(new java.awt.Color(255, 179, 179));
        getFirePic(panel);
        JLabel text1 = new JLabel(name + " is a Fire type.");
        panel.add(text1);
        text1.setBounds(150,200,500,100);
        text1.setFont(new Font("Calibri", 1, 20));
        JLabel text2 = new JLabel(name + " is strong against Grass type Pokemon");
        panel.add(text2);
        text2.setBounds(150,230,600,100);
        text2.setFont(new Font("Calibri", 1, 20));
        JLabel text3 = new JLabel("and weak against Water and Fire type Pokemon");
        panel.add(text3);
        text3.setBounds(150,260,600,100);
        text3.setFont(new Font("Calibri", 1, 20));
        System.out.println("It is a Fire type.");
        System.out.println(name + " is strong against Grass type Pokemon");
        System.out.println("and weak against Water and Fire type Pokemon");
    }

    //EFFECTS:import a picture of Charmander
    //        image from https://medium.com/the-pokemon-journal/charmander-family-202bde2418f8
    private void getFirePic(JPanel panel) {
        ImageIcon charmander = new ImageIcon("data/charmander.jpg");
        JLabel label = new JLabel(charmander);
        panel.add(label);
        label.setBounds(450,50,170,200);
    }


    //EFFECT: show text (name, type, counters, being countered by) if Pokemon is grass type
    public void grassText(String name, JPanel panel) {
        panel.setBackground(new java.awt.Color(179, 255, 179));
        getGrassPic(panel);
        JLabel text1 = new JLabel(name + " is a Grass type.");
        panel.add(text1);
        text1.setBounds(150,200,500,100);
        text1.setFont(new Font("Calibri", 1, 20));
        JLabel text2 = new JLabel(name + " is strong against Water type Pokemon");
        panel.add(text2);
        text2.setBounds(150,230,600,100);
        text2.setFont(new Font("Calibri", 1, 20));
        JLabel text3 = new JLabel("and weak against Fire and Grass type Pokemon");
        panel.add(text3);
        text3.setBounds(150,260,600,100);
        text3.setFont(new Font("Calibri", 1, 20));
        System.out.println("It is a Grass type.");
        System.out.println(name + " is strong against Water type Pokemon.");
        System.out.println("and weak against Fire and Grass type Pokemon");
    }

    //EFFECTS:import a picture of Bulbasaur
    //        image from https://www.quora.com/Which-is-the-strongest-Pokemon-Charmander-Bulbasaur-or-Squirtle
    private void getGrassPic(JPanel panel) {
        ImageIcon bulby = new ImageIcon("data/bulbasaur.jpg");
        JLabel label = new JLabel(bulby);
        panel.add(label);
        label.setBounds(450,50,170,200);
    }

    //EFFECTS: add a new Pokemontype hashMap
    public void addType(String type) {
        typeAndName.put(type, new ArrayList<>());
    }

    //EFFECTS: add Pokemon to the appropriate type in hashMap
    public void addPokemonToType(String type, String name) {
        ArrayList<String> names = typeAndName.get(type);
        names.add(name);
    }

}