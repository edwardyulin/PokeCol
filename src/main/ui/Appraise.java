package ui;


import model.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;


public class Appraise {
    private double att = Math.random();
    private double def = Math.random();
    private double sta = Math.random();
    private Pokemon pokemon;
    private ArrayList<Integer> stats;
    private ArrayList<Double> listOfDouble;
    private String pinap;
    private String nanab;
    private String razz;


    //EFFECTS: find the integer value for all att, def and sta and call the appraise system
    public Appraise(String name, String feed, JPanel panel) {
        stats = new ArrayList<>();
        listOfDouble = new ArrayList<>();
        listOfDouble.add(att);
        listOfDouble.add(def);
        listOfDouble.add(sta);
        stats = initializeStatsIntoList(listOfDouble);
        pokemon = new Pokemon(name, stats);
        JButton mainMenu = new JButton("Main Menu");
        panel.add(mainMenu);
        mainMenu.setBounds(300,440,150,50);
        mainMenu.setFont(new Font("Calibri", 1, 20));

        mainMenu.addActionListener(e -> {
            panel.removeAll();
            panel.invalidate();
            panel.repaint();
            IntroInterface.gameInterface(panel);
        });
        if (feed.equals("none")) {
            showStat(pokemon, panel);
        } else {
            appraiseSystem(pokemon, feed, panel);
        }
    }

    //MODIFIES: this, listOfDouble
    //EFFECTS: convert the list of stats in double to integers
    private ArrayList<Integer> initializeStatsIntoList(ArrayList<Double> listOfDouble) {
        for (Double d : listOfDouble) {
            d = d * 15 + 1;
            int stat = (int) Math.round(d);
            this.stats.add(stat);
        }
        return stats;
    }



    //EFFECTS: Print out the size of the Pokemon based on attInt, defInt and staInt then print each of them
    public void appraiseSystem(Pokemon pokemon, String feed,JPanel panel) {
        String trimmedText = pokemon.getName().trim();
        if (trimmedText.isEmpty()) {
            errorText(panel);
        } else {
            getBigMidSmall(pokemon, feed, panel);
        }
    }

    //EFFECTS: output the appropriate text for its corresponding size in GUI
    private String getBigMidSmall(Pokemon pokemon, String feed, JPanel panel) {
        System.out.println("Hey! You want me to check out " + pokemon.getName() + "?");
        appraiseText(panel);
        if (getSumStats(pokemon) >= 25) {
            bigText(panel);
            showStat(pokemon, panel);
            feedBerry(pokemon, feed);
            return "big";
        } else if ((24 >= getSumStats(pokemon)) && (getSumStats(pokemon) >= 10)) {
            midText(panel);
            showStat(pokemon, panel);
            feedBerry(pokemon, feed);
            return "mid";
        } else {
            smallText(panel);
            showStat(pokemon, panel);
            feedBerry(pokemon, feed);
            return "small";
        }
    }

    //EFFECTS: error text when Pokemon name is invalid in GUI
    private void errorText(JPanel panel) {
        JLabel error = new JLabel("That is an invalid name, please try again!");
        panel.add(error);
        error.setBounds(150,250,500,50);
        error.setFont(new Font("Calibri", 1, 20));
    }

    //EFFECTS: show the text for appraise in GUI
    private void appraiseText(JPanel panel) {
        JLabel checkOut = new JLabel("Hey! You want me to check out " + pokemon.getName() + "?");
        panel.add(checkOut);
        checkOut.setBounds(150,200,500,50);
        checkOut.setFont(new Font("Calibri", 1, 20));
    }

    //EFFECTS: show the text if Pokemon is BIG
    private void bigText(JPanel panel) {
        JLabel big = new JLabel("This " + pokemon.getName() + " is a BIG one!");
        panel.add(big);
        big.setBounds(150,250,500,50);
        big.setFont(new Font("Calibri", 1, 20));
        System.out.println("This " + pokemon.getName() + " is a BIG one!");
    }

    //EFFECTS: show the text if Pokemon is average
    private void midText(JPanel panel) {
        JLabel mid = new JLabel("This " + pokemon.getName() + " has average size!");
        panel.add(mid);
        mid.setBounds(150,250,500,50);
        mid.setFont(new Font("Calibri", 1, 20));
        System.out.println("This " + pokemon.getName() + " has average size!");
    }

    //EFFECTS: show the text if Pokemon is small
    private void smallText(JPanel panel) {
        JLabel small = new JLabel("This " + pokemon.getName() + " is a tiny one!");
        panel.add(small);
        small.setBounds(150,250,500,50);
        small.setFont(new Font("Calibri", 1, 20));
        System.out.println("This " + pokemon.getName() + " is a tiny one!");
    }

    //EFFECTS: add up all three stats to determine the size of the Pokemon
    private Integer getSumStats(Pokemon pokemon) {
        return pokemon.getAtt() + pokemon.getDef() + pokemon.getSta();
    }

    //EFFECTS: show all three stats in GUI
    private static void showStat(Pokemon pokemon, JPanel panel) {
        JLabel attackText = new JLabel(pokemon.getName() + " has attack of " + pokemon.getAtt());
        panel.add(attackText);
        attackText.setBounds(150,300,500,100);
        attackText.setFont(new Font("Calibri", 1, 20));
        JLabel defenseText = new JLabel(pokemon.getName() + " has defense of " + pokemon.getDef());
        panel.add(defenseText);
        defenseText.setBounds(150,320,500,100);
        defenseText.setFont(new Font("Calibri", 1, 20));
        JLabel staminaText = new JLabel(pokemon.getName() + " has stamina of " + pokemon.getSta());
        panel.add(staminaText);
        staminaText.setBounds(150,340,500,100);
        staminaText.setFont(new Font("Calibri", 1, 20));
        System.out.println(pokemon.getName() + " has attack of " + pokemon.getAtt());
        System.out.println(pokemon.getName() + " has defense of " + pokemon.getDef());
        System.out.println(pokemon.getName() + " has stamina of " + pokemon.getSta());
    }

    //EFFECTS: feed berry if the user wants to feed it to the Pokemon in UI console only
    public void feedBerry(Pokemon pokemon, String feed) {
        pinap = "1";
        nanab = "2";
        razz = "3";
        feedPinapBerry(pokemon, feed);
        feedNanabBerry(pokemon, feed);
        feedRazzBerry(pokemon, feed);
    }

    //EFFECTS: feed Pinap berry to the Pokemon and increase its attack by 1 in UI console only
    private void feedPinapBerry(Pokemon pokemon, String berry) {
        if (berry.equals(pinap)) {
            int newAtt = pokemon.setAtt(pokemon.getAtt() + 1);
            System.out.println(pokemon.getName() + "'s attack has increased to " + newAtt);
        }
    }

    //EFFECTS: feed Nanab berry to the Pokemon and increase its defense by 1 in UI console only
    private void feedNanabBerry(Pokemon pokemon, String berry) {
        if (berry.equals(nanab)) {
            int newDef = pokemon.setDef(pokemon.getDef() + 1);
            System.out.println(pokemon.getName() + "'s defence has increased to " + newDef);
        }
    }

    //EFFECTS: feed Razz berry to the Pokemon and increase its stamina by 1 in UI console only
    private void feedRazzBerry(Pokemon pokemon, String berry) {
        if (berry.equals(razz)) {
            int newSta = pokemon.setSta(pokemon.getSta() + 1);
            System.out.println(pokemon.getName() + "'s stamina has increased to " + newSta);
        }
    }
}
