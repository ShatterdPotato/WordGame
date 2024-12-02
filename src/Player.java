public class Player {
    //instance variables
    private int health;
    private int attackDMG;
    private String name;

    //constructor for when the client wants to choose their health and attack power
    public Player(int health, int attackDMG, String name) {
        this.health = health;
        this.attackDMG = attackDMG;
        this.name = name;
    }

    //constructor that assigns to default values
    public Player(String name) {
        this.name = name;
        health = 100;
        attackDMG = 10;
    }

    //getters
    public int getHealth() {
        return health;
    }

    public int getAttackDMG() {
        return attackDMG;
    }

    public String getName() {
        return name;
    }

    //increments the enemy's HP by given amount
    public void heal(int healAmount) {
        health += healAmount;
    }

    //overloaded heal method that generates the heal amount in the method
    public void heal() {
        health += (int) (Math.random() * 20) + 1;
    }

    //decrements the enemy's HP by given amount
    public void attacked(int DMGAmount) {
        health -= DMGAmount;
    }

    //overloaded attack method that generates the DMG amount in the method
    public void attacked() {
        health -= (int) (Math.random() * 20) + 1;
    }
}
