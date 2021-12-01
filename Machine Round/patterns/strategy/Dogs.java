package patterns.strategy;

public class Dogs extends Animal {

    public void digHole() {
        System.out.println("Dug a hole");
    }

    public Dogs() {
        super();

        setSound("Bark");
        // We set the Flys interface polymorphically
        // This sets the behavior as a non-flying Animal
        flyingType = new CantFly();
    }
}
