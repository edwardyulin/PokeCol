package model;


public class Audience implements TrainersObserver {
    private String name;

    public Audience(String name) {
        this.name = name;
    }

    @Override
    //EFFECTS: concrete observer that print appropriate text every time it is updated and return "Updated"
    public String update(Pokemon p) {
        System.out.println();
        System.out.println(name + " thinks ");
        //new Appraise(p.getName(), "none", null);
        return "Updated";
    }
}
