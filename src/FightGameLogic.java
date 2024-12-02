import java.util.Scanner;

public class FightGameLogic {
    //instance variables
    private Scanner scan;
    private Player player;
    private Enemy enemy;
    private int waveNum;

    //constructor
    public FightGameLogic() {
        scan = new Scanner(System.in);
        enemy = new Enemy();
        waveNum = 1;
    }

    public void run() {
        initializePlayer();  //private helper to create player class
        System.out.println("\nWelcome to Fight Game! Try to survive as long as you can against different monsters! \nGood Luck!");

        //main game loop
        while (player.getHealth() > 0) {
            playEncounter();    //single wave method
            //round results
            if (player.getHealth() > 0) {
                System.out.println("\nYou won!");
            }   else {
                System.out.println("\nYou lost!");
                System.out.println("You survived for " + waveNum + " waves!");
            }
            waveNum++;  //increment waveNum to be next correct for next iteration
        }
    }

    //deals with the logic for a single wave
    private void playEncounter() {
        enemy.setStats();  //reinitialize the enemy at the start of each round to be "refurbished"
        //Start of wave header
        System.out.println("WAVE " + waveNum);
        System.out.println("A " + enemy.getName() + " appears from the bushes!");
        System.out.println();

        //single turn loop
        while (enemy.getHealth() > 0 && player.getHealth() > 0) {
            System.out.println("Enemy HP: " + enemy.getHealth());
            System.out.println("Player HP: " + player.getHealth());
            System.out.println();
            System.out.print("What will you do? (attack/heal): ");
            String action = scan.nextLine();
            move(action);   //private helper that deals with action
        }
    }

    //This method deals with the action logic for both player and enemy
    private void move(String action) {
        //player action
        if (action.equals("attack")) {
            System.out.println("You attacked for " + player.getAttackDMG() + "!");
            if ((int) (Math.random() * 3) + 1 == 1) {   //critical hit
                System.out.println(player.getName() + " GETS LUCKY AND DEALS A CRITICAL HIT FOR DOUBLE THE DMG AMOUNT!!!!");
                enemy.attacked(player.getAttackDMG());
            }
            enemy.attacked(player.getAttackDMG());
        }   else if (action.equals("heal")) {
            int healAmount = (int) (Math.random() * 11) + 10;
            System.out.println("You healed for " + healAmount + " HP!");
            if ((int) (Math.random() * 3) + 1 == 1) {   //critical heal
                healAmount *= 2;
                System.out.println(player.getName() + " GETS LUCKY AND HEALS FOR DOUBLE THE HEAL AMOUNT!!!!");
            }
            player.heal(healAmount);
        }   else if (action.equals("suicide")) {
            System.out.println(player.getName() + " realizes that in the effort to extinguish the world from monsters, they themselves became one.\nAs the sins of their actions bear down on them, they stab themselves with their blade, praying that in the wake of their demise, the world breathes a little more peacefully.");
            player.attacked(10000000);
        }   else {
            System.out.println(doNothing());
        }

        //enemy action
        if (player.getHealth() > 0 && enemy.getHealth() > 0) {
            if ((int) (Math.random() * 2) + 1 == 1) {
                System.out.println(enemy.getName() + " attacked " + player.getName() + " for " + enemy.getAttackDMG() + "!");
                if ((int) (Math.random() * 3) + 1 == 1) {   //critical hit
                    System.out.println(enemy.getName() + " GETS LUCKY AND DEALS A CRITICAL HIT FOR DOUBLE THE DMG AMOUNT!!!!");
                    player.attacked(enemy.getAttackDMG());
                }
                player.attacked(enemy.getAttackDMG());
            } else {
                int healAmount = (int) (Math.random() * 11) + 10;
                System.out.println(enemy.getName() + " healed for " + healAmount + " HP!");
                if ((int) (Math.random() * 3) + 1 == 1) {   //critical heal
                    healAmount *= 2;
                    System.out.println(enemy.getName() + " GETS LUCKY AND HEALS FOR DOUBLE THE HEAL AMOUNT!!!!");
                }
                enemy.heal(healAmount);
            }
        }
    }

    //This method extracts information from the user in order to properly initialize the player instance to respect the client's wishes
    private void initializePlayer() {
        System.out.print("What is your name?: ");
        String name = scan.nextLine();
        System.out.println("Welcome " + name + "!");
        System.out.print("Do you want to preset damage and health value or leave it random? (y/n): ");
        String answer = scan.nextLine();

        if (answer.indexOf("y") != -1) {
            System.out.print("Enter damage output: ");
            int DMG = scan.nextInt();
            scan.nextLine();
            System.out.print("Enter health: ");
            int HP = scan.nextInt();
            scan.nextLine();
            player = new Player(HP, DMG, name);
        }   else {
            player = new Player(name);
        }
    }

    //this method returns a fun string that can be used if the program detects an action that isnt attack or heal
    private String doNothing() {
        int random = (int) (Math.random() * 5) + 1;
        if (random == 1) {
            return player.getName() + " trips on a branch!";
        }   else if (random == 2) {
            return player.getName() + " picks some dandelions!";
        }   else if (random == 3) {
            return player.getName() + " gets hungry and takes out their lunch, only to drop it";
        }   else if (random == 4) {
            return player.getName() + " decides to scroll through TikTok, unfazed by the current situation";
        }   else {
            return player.getName() + " does absolutely nothing!";
        }
    }
}
