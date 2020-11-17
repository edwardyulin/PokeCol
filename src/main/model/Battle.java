package model;


public class Battle {

    public Battle() {
    }


    //EFFECTS: text produced when battling with a trainer, return either "Misty" or "Brock"
    public static String toBattlefield(String name) {
        System.out.println("You are battling " + name);
        if (name.equals("Misty")) {
            return "Misty";
        }
        return "Brock";
    }

    //EFFECTS: text produced when battling Team Rocket, return "Rocket"
    public static String fightTeamRocket(String name) {
        System.out.println("Team Rocket!");
        return "Rocket";
    }
}
