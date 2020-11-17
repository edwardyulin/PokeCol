package model;


public class Map {

    public Map() {
        makeAMap();
    }

    //EFFECT: draws out a map of a particular region with places and trainers
    private void makeAMap() {
        Places gym = new Places("Gym");
        Places park = new Places("Park");
        Places pool = new Places("Pool");
        Trainer brock = new Trainer("Brock");
        Trainer misty = new Trainer("Misty");
        Trainer jessie = new Trainer("Jessie");
        Trainer james = new Trainer("James");
        park.add(gym);
        park.add(pool);
        park.add(jessie);
        park.add(james);
        gym.add(brock);
        pool.add(misty);
        park.display("(Region name)");
    }

    //EFFECTS: print the location of places (in other places) and the trainers and return "Battle" or "Rocket"
    //         depending on who the user wants to battle with
    public static String print(String location, String itemName) {
        String printText = itemName + " is in the " + location;
        System.out.println(printText);
        if ((itemName.equals("Brock")) || (itemName.equals("Misty"))) {
            makeObservers(itemName);
            Battle.toBattlefield(itemName);
            return "Battle";
        } else if ((itemName.equals("Jessie")) || (itemName.equals("James"))) {
            Battle.fightTeamRocket(itemName);
            return "Rocket";
        }
        return "";
    }

    //EFFECTS: add new observers (audiences) for each trainer and call assignPokemon
    private static void makeObservers(String name) {
        Trainer trainer = new Trainer(name);
        Audience chal1 = new Audience("Professor Oak");
        Audience chal2 = new Audience("A random kid");
        Audience chal3 = new Audience("I");

        trainer.addObserver(chal1);
        trainer.addObserver(chal2);
        trainer.addObserver(chal3);

        assignPokemon(trainer);
    }

    //EFFECTS: assign Pokemon to appropriate trainer
    private static void assignPokemon(Trainer trainer) {
        Pokemon psyduck = new Pokemon("Psyduck", null);
        Pokemon togepi = new Pokemon("Togepi", null);
        Pokemon staryu = new Pokemon("Staryu", null);
        Pokemon onix = new Pokemon("Onix", null);
        Pokemon geodude = new Pokemon("Geodude", null);
        Pokemon zubat = new Pokemon("Zubat", null);
        if (trainer.name.equals("Brock")) {
            trainer.addPokemon(onix);
            trainer.addPokemon(geodude);
            trainer.addPokemon(zubat);
        } else if (trainer.name.equals("Misty")) {
            trainer.addPokemon(psyduck);
            trainer.addPokemon(togepi);
            trainer.addPokemon(staryu);
        }
    }
}
