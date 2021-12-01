package patterns.strategy;

public class Test {
    public static void main(String[] args) {

        Animal sparky = new Dogs();
        Animal tweety = new Bird();

        System.out.println("Dog: " + sparky.tryToFly());
        System.out.println("Bird: " + tweety.tryToFly());

        // This allows dynamic changes for flyingType
        sparky.setFlyingAbility(new ItFlys());
        System.out.println("Dog: " + sparky.tryToFly());
    }

}
