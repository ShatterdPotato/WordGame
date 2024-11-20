import java.util.Scanner;

public class FightGameLogic {
    private Scanner scan;
    private Player player;
    private Enemy enemy;
    private int waveNum;

    public FightGameLogic() {
        scan = new Scanner(System.in);
        enemy = new Enemy();
        waveNum = 1;
    }


    public void run() {
        initializePlayer();
        System.out.println("\nWelcome to Fight Game! Try to survive as long as you can against different monsters! \nGood Luck!");

        while (player.getHealth() > 0) {
            playEncounter();
            if (player.getHealth() > 0) {
                System.out.println("\nYou won!");
            }   else {
                System.out.println("\nYou lost!");
                System.out.println("You survived for " + waveNum + " waves!");
            }
            waveNum++;
        }
    }

    private void playEncounter() {
        enemy.setStats();
        System.out.println("WAVE " + waveNum);
        System.out.println("A " + enemy.getName() + " appears from the bushes!");
        System.out.println();
        while (enemy.getHealth() > 0 && player.getHealth() > 0) {
            System.out.println("Enemy HP: " + enemy.getHealth());
            System.out.println("Player HP: " + player.getHealth());
            System.out.println();
            System.out.print("What will you do? (attack/heal): ");
            String action = scan.nextLine();
            if (action.equals("attack")) {
                System.out.println("You attacked for " + player.getAttackDMG() + "!");
                enemy.attacked(player.getAttackDMG());
            }   else if (action.equals("heal")) {
                int healAmount = (int) (Math.random() * 11) + 10;
                System.out.println("You healed for " + healAmount + " HP!");
                player.heal(healAmount);
            }
            if ((int) (Math.random() * 2) + 1 == 1) {
                System.out.println(enemy.getName() +  " attacked " + player.getName() + " for " +  enemy.getAttackDMG() + "!");
                player.attacked(enemy.getAttackDMG());
            }  else {
                int healAmount = (int) (Math.random() * 11) + 10;
                System.out.println(enemy.getName() + " healed for " + healAmount + " HP!");
                enemy.heal(healAmount);
            }
        }
    }

    private void initializePlayer() {
        System.out.print("What is your name?: ");
        String name = scan.nextLine();
        System.out.println("Welcome " + name + "!");
        System.out.print("Do you want to preset damage and health value or leave it random? (y/n): ");
        String answer = scan.nextLine();
        if (answer.equals("n")) {
            player = new Player(name);
        }   else if (answer.equals("y")) {
            System.out.print("Enter damage output: ");
            int DMG = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter health: ");
            int HP = scan.nextInt();
            scan.nextLine();
            player = new Player(HP, DMG, name);
        }
    }
}
