package ui;

import model.MyOrganizer;
import model.OpponentOrganizer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class IntroInterface extends JPanel {
    public static ArrayList<String> myCollection;
    public static ArrayList<String> oppoCollection;
    private static int WIDTH = 800;
    private static int HEIGHT = 600;
    private JFrame frame;


    //EFFECTS: initiates a collection and the input of name from the user, proceed to gameInterface
    public IntroInterface() {
        myCollection = new ArrayList<>();
        oppoCollection = new ArrayList<>();
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));



        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.add(panel);

        firstIntroduction(panel);
    }

    //EFFECTS: presents the first interface of the program with a title, a start button and a background
    //         image from https://www.pinterest.com/pin/840062136712467210/
    private void firstIntroduction(JPanel panel) {

        JButton title = new JButton("Gotta Catch 'Em All");
        panel.add(title);
        title.setPreferredSize(new Dimension(780, 100));
        title.setFont(new java.awt.Font("Calibri", 1, 60));

        JButton button = new JButton("Start");
        panel.add(button);
        button.setPreferredSize(new Dimension(300, 100));
        button.setFont(new java.awt.Font("Calibri", 1, 78));

        ImageIcon ash = new ImageIcon("data/first.png");
        JLabel label = new JLabel(ash);
        panel.add(label);
        label.setBounds(0,0,800,600);



        button.addActionListener(e -> {
            removeAllRepaintRevalidate(panel);
            gameInterface(panel);
        });
    }

    //EFFECTS: the general method that removes all previous contents on the screen
    private void removeAllRepaintRevalidate(JPanel panel) {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }


    //EFFECTS: the second interface where the user is told to press Enter to select the appropriate collection
    public static void gameInterface(JPanel panel) {
        panel.setBackground(new java.awt.Color(255, 204, 255));
        panel.setLayout(null);

        addIntro(panel);

        JLabel toEnter = new JLabel("Press 'Start' to continue");
        toEnter.setBounds(230,150,1000,100);
        toEnter.setFont(new Font("Calibri", 1, 25));
        panel.add(toEnter);

        JButton start = new JButton("Start");
        start.setBounds(325,300,100,50);
        start.setFont(new Font("Calibri", 1, 20));
        panel.add(start);

        JButton quit = new JButton("Quit");
        quit.setBounds(700,530,100,50);
        quit.setFont(new Font("Calibri", 1, 20));
        panel.add(quit);

        quit.addActionListener(e -> System.exit(0));

        start.addActionListener(e -> whichCollection(panel));
    }

    //EFFECTS: show a welcome message to the user upon entering the second interface
    private static void addIntro(JPanel panel) {
        JLabel toDo = new JLabel("Welcome to the Pokemon Operation System");
        toDo.setBounds(100,50,1000,100);
        toDo.setFont(new Font("Calibri", 1, 25));
        panel.add(toDo);
    }

    //EFFECTS: a general broad method that calls "Your Collection"
    private static void whichCollection(JPanel panel) {
        panel.remove(3);
        panel.remove(2);
        panel.remove(1);
        panel.setBackground(new java.awt.Color(255, 255, 153));
        whichCollectionText(panel);
        panel.setLayout(null);

        goToYours(panel);
        goToOpponents(panel);
    }



    private static void goToYours(JPanel panel) {
        JButton myCol = new JButton("Your Collection");
        myCol.setBounds(150,300,200,50);
        myCol.setFont(new Font("Calibri", 1, 20));
        panel.add(myCol);
        myCol.addActionListener(e -> {
            panel.remove(3);
            panel.remove(2);
            new MyOrganizer(myCollection, panel);
        });
    }

    private static void goToOpponents(JPanel panel) {
        JButton oppoCol = new JButton("Opponent's Collection");
        oppoCol.setBounds(350,300,250,50);
        oppoCol.setFont(new Font("Calibri", 1, 20));
        panel.add(oppoCol);



        oppoCol.addActionListener(e -> {
            panel.remove(3);
            panel.remove(2);
            new OpponentOrganizer(oppoCollection, panel);
        });
    }

    private static void whichCollectionText(JPanel panel) {
        JLabel whichCol = new JLabel("         ");
        whichCol.setBounds(150,200,600,50);
        whichCol.setFont(new Font("Calibri", 1, 20));
        panel.add(whichCol);
    }
}