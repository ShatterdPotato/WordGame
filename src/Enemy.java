public class Enemy {
    //instance variables
    private int health;
    private int attackDMG;
    private String name;

    //constructor (no parameters)
    public Enemy() {
        setStats();
    }

    //overloaded constructor with three custom set parameters to explicitly assign the instance variables (not used)
    public Enemy(int health, int attackDMG, String name) {
        this.health = health;
        this.attackDMG = attackDMG;
        this.name = name;
    }

    //getters
    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getAttackDMG() {
        return attackDMG;
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

    //refreshes all the instance variables in order for the enemy to be "new" for the start of the next wave
    public void setStats() {
        this.health = (int) (Math.random() * 101) + 100;
        this.attackDMG = (int) (Math.random() * 11) + 10;
        chooseName();   //private helper
    }

    //generates a random name for the enemy to add variety
    private void chooseName() {
        int random = (int) (Math.random() * 5) + 1;
        if (random == 1) {
            name = "Zombie";
        }   else if (random == 2) {
            name = "Skeleton";
        }   else if (random == 3) {
            name = "Mummy";
        }   else if (random == 4) {
            name = "Spider";
        }   else {
            name = "Ghoul";
        }
    }
}
