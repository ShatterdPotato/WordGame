public class Player {
    private int health;
    private int attackDMG;
    private String name;

    public Player(int health, int attackDMG, String name) {
        this.health = health;
        this.attackDMG = attackDMG;
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
        health = 100;
        attackDMG = 10;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDMG() {
        return attackDMG;
    }

    public String getName() {
        return name;
    }

    public void heal(int healAmount) {
        health += healAmount;
    }

    public void attacked(int DMGAmount) {
        health -= DMGAmount;
    }
}
