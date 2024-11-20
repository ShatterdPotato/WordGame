public class Enemy {
    private int health;
    private int attackDMG;
    private String name;

    public Enemy() {
        setStats();
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getAttackDMG() {
        return attackDMG;
    }

    public void heal(int healAmount) {
        health += healAmount;
    }

    public void attacked(int DMGAmount) {
        health -= DMGAmount;
    }

    public void setStats() {
        this.health = (int) (Math.random() * 101) + 100;
        this.attackDMG = (int) (Math.random() * 11) + 10;
        chooseName();
    }

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
