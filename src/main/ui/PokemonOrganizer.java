package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class PokemonOrganizer {
    protected Scanner scanner;


    public PokemonOrganizer() {
        scanner = new Scanner(System.in);
    }

    //EFFECTS: shows the text upon entering the collection for different user
    protected  void greetText(JPanel panel) {
        panel.setBackground(new java.awt.Color(236, 255, 179));
        JLabel toDo = new JLabel("Welcome to " + getTrainer() + " collection!");
        toDo.setBounds(150,120,450,50);
        toDo.setFont(new Font("Calibri", 1, 20));
        panel.add(toDo);
    }


    public abstract String getTrainer();

    //EFFECTS: a method that encapsulates the 4 functionality plus a main menu button
    public void selectionText(ArrayList<String> collection, JPanel panel) {
        mainMenu(panel);
        appraise(panel, collection);
        counters(panel, collection);
        store(panel, collection);
        preTransfer(panel, collection);
    }

    //EFFECTS: added the button for transferring Pokemon and goes to gameSelection() with selection of 4
    private void preTransfer(JPanel panel, ArrayList<String> collection) {
        JButton transfer = new JButton("Transfer");
        transfer.setBounds(450,300,150,50);
        transfer.setFont(new Font("Calibri", 1, 20));
        panel.add(transfer);
        transfer.addActionListener(e -> {
//            panel.remove(8);
            panel.remove(7);
            panel.remove(6);
            panel.remove(5);
            panel.remove(4);
            panel.validate();
            panel.repaint();
            gameSelection("4", collection, panel);
        });
    }

    //EFFECTS: added the button for storing Pokemon and goes to gameSelection() with selection of 3
    private void store(JPanel panel, ArrayList<String> collection) {
        JButton store = new JButton("Store to Collection");
        store.setBounds(100,300,250,50);
        store.setFont(new Font("Calibri", 1, 20));
        panel.add(store);
        store.addActionListener(e -> {
//            panel.remove(8);
            panel.remove(7);
            panel.remove(6);
            panel.remove(5);
            panel.remove(4);
            panel.validate();
            panel.repaint();
            gameSelection("3", collection, panel);
        });
    }

    //EFFECTS: added the button for showing Pokemon's counters and goes to gameSelection() with selection of 2
    private void counters(JPanel panel, ArrayList<String> collection) {
        JButton counters = new JButton("Counters");
        counters.setBounds(450,200,150,50);
        counters.setFont(new Font("Calibri", 1, 20));
        panel.add(counters);
        counters.addActionListener(e -> {
//            panel.remove(8);
            panel.remove(7);
            panel.remove(6);
            panel.remove(5);
            panel.remove(4);
            panel.validate();
            panel.repaint();
            gameSelection("2",  collection, panel);
        });
    }

    //EFFECTS: added the button for checking Pokemon's stats and goes to gameSelection() with selection of 1
    private void appraise(JPanel panel, ArrayList<String> collection) {
        JButton appraise = new JButton("Appraise");
        appraise.setBounds(150,200,150,50);
        appraise.setFont(new Font("Calibri", 1, 20));
        panel.add(appraise);
        appraise.addActionListener(e -> {
//            panel.remove(8);
            panel.remove(7);
            panel.remove(6);
            panel.remove(5);
            panel.remove(4);
            panel.validate();
            panel.repaint();
            gameSelection("1", collection, panel);
        });
    }

    //EFFECTS: implemented a main menu button and go back to the SECOND interface when button is clicked
    private void mainMenu(JPanel panel) {
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(0,530,150,50);
        mainMenu.setFont(new Font("Calibri", 1, 20));
        panel.add(mainMenu);

        mainMenu.addActionListener(e -> {
            panel.removeAll();
            panel.invalidate();
            panel.repaint();
            IntroInterface.gameInterface(panel);
        });
    }



    //EFFECTS: produce a text field and an Enter button and go to enterAction() if enter is clicked
    public void gameSelection(String selection, ArrayList<String> collection, JPanel panel) {
        JButton enter = new JButton("Enter");
        enter.setBounds(550,500,100,50);
        enter.setFont(new Font("Calibri", 1, 20));
        panel.add(enter);
        JTextField pokeName = new JTextField();
        pokeName.setBounds(150,500,350,50);
        panel.add(pokeName);

        getNameText(selection, panel);

        enter.addActionListener(e -> {
            enterAction(selection, panel, pokeName.getText(), collection);
        });
    }

    //EFFECTS: go to the appropriate class/method for different selection of functions
    private void enterAction(String selection, JPanel panel, String name, ArrayList<String> collection) {
        if (selection.equals("1")) {
            removeRepaintRevalidate(panel);
            new Appraise(name, "0", panel);
        } else if (selection.equals("2")) {
            removeRepaintRevalidate(panel);
            new Counters(name, panel);
        } else if (selection.equals("3")) {
            removeRepaintRevalidate(panel);
            addTo(name, collection, panel);
        } else {
            removeRepaintRevalidate(panel);
            transfer(name, collection, panel);
        }
    }

    //EFFECTS: the general method that removes all previous content when the interface changed
    private void removeRepaintRevalidate(JPanel panel) {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }


    public abstract String getTrainerName();

    //EFFECTS: provide text above the text field for appraise and counters
    private void getNameText(String selection, JPanel panel) {
        if (selection.equals("1")) {
            JLabel pokeToAppraise = new JLabel("Name of the Pokemon to appraise:");
            pokeToAppraise.setBounds(150,450,500,50);
            pokeToAppraise.setFont(new Font("Calibri", 1, 20));
            panel.add(pokeToAppraise);
        } else if (selection.equals("2")) {
            JLabel pokeToCounter = new JLabel("Name of the Pokemon to show counter:");
            pokeToCounter.setBounds(150,450,500,50);
            pokeToCounter.setFont(new Font("Calibri", 1, 20));
            panel.add(pokeToCounter);
        } else {
            getNameTextPartTwo(selection, panel);
        }
    }

    //EFFECTS: provide text above the text field for storing and transferring Pokemon
    private void getNameTextPartTwo(String selection, JPanel panel) {
        if (selection.equals("3")) {
            JLabel pokeToStore = new JLabel("Name of the Pokemon to store:");
            pokeToStore.setBounds(150,450,500,50);
            pokeToStore.setFont(new Font("Calibri", 1, 20));
            panel.add(pokeToStore);
        } else if (selection.equals("4")) {
            JLabel pokeToTransfer = new JLabel("Name of the Pokemon to transfer:");
            pokeToTransfer.setBounds(150,450,500,50);
            pokeToTransfer.setFont(new Font("Calibri", 1, 20));
            panel.add(pokeToTransfer);
        }
    }

    //EFFECTS: store Pokemon to the collection if name is appropriate
    //         navigate back to the SECOND interface after confirm button is pressed
    private void addTo(String name, ArrayList<String> collection, JPanel panel) {
        String trimmedText = name.trim();
        if (trimmedText.isEmpty()) {
            errorText(panel);
        } else {
            collection.add(name);
            addAsh(panel);
            addToCollectionText(name, panel);
            collectionNowText(collection, panel);
        }
        JButton listNow = new JButton("Confirm");
        panel.add(listNow);
        listNow.setBounds(150, 400, 200, 50);
        listNow.setFont(new Font("Calibri", 1, 20));
        listNow.addActionListener(e -> {
            removeRepaintRevalidate(panel);
            IntroInterface.gameInterface(panel);
        });

    }

    //EFFECTS: shows a text of what the collection currently has for the store function and the transfer function
    private void collectionNowText(ArrayList<String> collection, JPanel panel) {
        JLabel nameAdded = new JLabel(getTrainer() + " collection now has " + collection);
        panel.add(nameAdded);
        nameAdded.setBounds(150, 350, 500, 50);
        nameAdded.setFont(new Font("Calibri", 1, 20));
        System.out.println(getTrainer() + " collection now has " + collection);
    }

   //EFFECTS: error text for store/transfer if only space is entered for Pokemon name
    private void errorText(JPanel panel) {
        JLabel error = new JLabel("That is an invalid name, please try again!");
        panel.add(error);
        error.setBounds(150,250,500,50);
        error.setFont(new Font("Calibri", 1, 20));
    }

    //EFFECTS: shows the text of for whom has added which pokemon
    private void addToCollectionText(String name, JPanel panel) {
        JLabel pokeName = new JLabel(getTrainerName() + " added " + name + " to the collection.");
        panel.add(pokeName);
        pokeName.setBounds(150,300,500,50);
        pokeName.setFont(new Font("Calibri", 1, 20));
    }

    //EFFECTS: added an image of "happy Ash" after the Pokemon is added to the collection
    //         image from https://www.joe.co.uk/entertainment/pokemon-ash-ketchum-win-239606
    private void addAsh(JPanel panel) {
        ImageIcon ash = new ImageIcon("data/ash.png");
        JLabel label = new JLabel(ash);
        panel.add(label);
        label.setBounds(180,50,400,200);
    }

    //EFFECTS: transfer Pokemon from the collection if name is appropriate
    //         navigate back to the SECOND interface after confirm button is pressed
    private void transfer(String name, ArrayList<String> collection, JPanel panel) {
        if (collection.contains(name)) {
            collection.remove(name);
            ashCry(panel);
            transferAwayText(name, panel);
            collectionNowText(collection, panel);
        } else {
            errorText(panel);
        }
        JButton listNow = new JButton("Confirm");
        panel.add(listNow);
        listNow.setBounds(150,400,200,50);
        listNow.setFont(new Font("Calibri", 1, 20));
        listNow.addActionListener(e -> {
            removeRepaintRevalidate(panel);
            IntroInterface.gameInterface(panel);
        });
    }

    //EFFECTS: show the text of Pokemon has been transferred away
    private void transferAwayText(String name, JPanel panel) {
        JLabel pokeName = new JLabel(getTrainerName() + " have transferred " + name + " away.");
        panel.add(pokeName);
        pokeName.setBounds(150,300,500,50);
        pokeName.setFont(new Font("Calibri", 1, 20));
    }

    //EFFECTS: added an image of "say Ash" after the Pokemon is transferred from the collection
    //         image from https://bulbapedia.bulbagarden.net/wiki/Mirror_Ash
    private void ashCry(JPanel panel) {
        ImageIcon ash = new ImageIcon("data/ashCry.png");
        JLabel label = new JLabel(ash);
        panel.add(label);
        label.setBounds(180, 50, 400, 200);
    }


}
