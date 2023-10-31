import java.util.Random;
import java.util.Scanner;

/**
 * The Battle class represents the battle phase between a player and a wild enemy Creature.
 * <p>
 * The battle involves a series of turns where the player can choose to attack, swap active Creatures,
 * attempt to catch the enemy Creature, or run away.
 * <p>
 * The battle phase ends when player successfully captures the enemy Creature, runs out of turns, or 
 * the enemy Creature runs away. The phase also ends when the player chooses to run away from the enemy Creature.
 * </p>
 */
public class Battle {
    /**
     * The player participating in the battle.
     */
    private Player CPlayer;

    /**
     * The enemy Creature the player is facing.
     */
    private Creature enemyCreature;

    /**
     * The current health of the enemy Creature.
     */
    private double enemyHealth;
    private Scanner scanner;

    /**
     * Constructs the new Battle object.
     * 
     * @param CPlayer        the player
     * @param enemyCreature  the randomly generated enemy Creature the player is facing
     * @param scanner        the scanner object for user input
     */
    public Battle(Player CPlayer, Creature enemyCreature, Scanner scanner){
        this.CPlayer = CPlayer;
        this.enemyCreature = enemyCreature;
        this.enemyHealth = 50.0;
        this.enemyCreature.setHealth(this.enemyHealth);
        this.scanner = scanner;
    }

    /**
     * Runs the entire battle sequence.
     * Allows the player to perform a series of actions such as attack, swap, or catch on the enemy Creature.
     * If the player runs out of turns, catches the enemy Creature, or the enemy Creature runs away, this phase ends.
     */
    public void commenceBattle() {
        int numberOfTurns = 3;
        System.out.println("-----------------------------------------------");
        System.out.println("\t  [ENTERING BATTLE PHASE]");
        System.out.println("\tA wild [" + enemyCreature.getName() + "] appeared!");
    
        System.out.println("\t  " + enemyCreature.getName() + "'s Health : " + enemyCreature.getHealth());
        System.out.println("\t Number of Player's turns: " + numberOfTurns);
    
        while (numberOfTurns > 0 && enemyCreature.getHealth() > 0) {
            System.out.println();
            System.out.println("What will " + CPlayer.getActiveCreature().getName() + " do?\n[1] Attack\n[2] Swap\n[3] Catch\n[4] Run Away");
    
            int choice = 0;
            boolean validChoice = false;
    
            while (!validChoice) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    validChoice = true;
                } 
                
                else {
                    System.out.println("Invalid input! Please enter a valid option.");
                    scanner.next();
                    System.out.println("What will " + CPlayer.getActiveCreature().getName() + " do?\n[1] Attack\n[2] Swap\n[3] Catch\n[4] Run Away");
                }
            }
    
            switch (choice) {
                case 1:
                    attack(CPlayer.getActiveCreature(), enemyCreature);
                    numberOfTurns--;
                    break;
                case 2:
                    if (CPlayer.getInventorySize() == 1) {
                        System.out.println("You only have one creature in your inventory. Swapping is not possible!");
                    } else {
                        swap();
                        numberOfTurns--;
                    }
                    break;
                case 3:
                    if (catchCreature()) {
                        System.out.println("---------------------------------------------------");
                        return;
                    }
                    else{
                        numberOfTurns--;
                    }
                    break;
                case 4:
                    System.out.println("You ran away!");
                    return;
                default:
                    System.out.print("Invalid choice! Choose another option\n");
            }
    
            System.out.println("Number of Player's turns: " + numberOfTurns);
        }
    
        if (numberOfTurns == 0) {
            System.out.println("[" + enemyCreature.getName() + "] has escaped! ");
            System.out.println("---------------------------------------------------");
        }
    }
    
    
    /**
     * Executes the attack sequence of the player's active Creature.
     * If the active Creature's Type precedes the enemy's Type, an additional 1.5 benefit is multiplied to the damage.
     * The enemy Creature's health is reduced promptly.
     * 
     * @param activeCreature  the player's current active Creature
     * @param enemyCreature   the enemy Creature the player is facing
     */
    public void attack(Creature activeCreature, Creature enemyCreature){
        Random random = new Random();
        int typeBenefit = 0;
    
        double nAttack = (1 + random.nextInt(10)) * activeCreature.getEL();
        System.out.println();
        System.out.println(activeCreature.getName() + " attacks!");
    
        if(activeCreature.getType().equals("Fire") && enemyCreature.getType().equals("Grass")){
            nAttack = nAttack * 1.5;
            typeBenefit++;
        } 
        
        else if (activeCreature.getType().equals("Grass") && enemyCreature.getType().equals("Water")){
            nAttack = nAttack * 1.5;
            typeBenefit++;
        } 
        
        else if (activeCreature.getType().equals("Water") && enemyCreature.getType().equals("Fire")){
            nAttack = nAttack * 1.5;
            typeBenefit++;
        }
    
        System.out.println("[" + activeCreature.getName() + "] deals " + nAttack + " damage to [" + enemyCreature.getName() + "]");

        if(typeBenefit == 1){
            System.out.println("It's super effective!");
        }
        
        enemyCreature.setHealth(enemyCreature.getHealth() - nAttack);
    
        System.out.println("["+ enemyCreature.getName() + "]'s Health : " + enemyCreature.getHealth());

        if(enemyCreature.getHealth() <= 0) {
            System.out.println("[" + enemyCreature.getName() + "] is defeated!");
        }
    }
    

    /**
     * Allows the player to swap their current active Creature.
     * The player chooses from the Creatures in their inventory to be the active Creature.
     */
    public void swap() {        
        System.out.println("\nYour current active creature is: [" + CPlayer.getActiveCreature().getName() + "]");
        System.out.println("Choose a creature from your Inventory to swap: ");
        CPlayer.showInventory();
        
        int nChoice = 0;
        boolean bValid = true;

        while (bValid) {
            if (scanner.hasNextInt()) {
                nChoice = scanner.nextInt();
                scanner.nextLine();
                
                if (nChoice >= 1 && nChoice <= CPlayer.getInventorySize()) {
                    CPlayer.setActiveCreature(nChoice - 1);
                    System.out.println("You swapped to: [" + CPlayer.getActiveCreature().getName() + "]");
                    bValid = false;
                } 
                
                else {
                    System.out.print("Invalid choice! Choose a valid option: ");
                }
            } 
            
            else {
                System.out.print("Invalid input! Please enter a valid option: ");
                scanner.next();
            }
        }
    }

    /**
     * Attempts to catch the enemy Creature based on a catch rate calculation.
     * Once prompted by the player, attamps to catch the enemy Creature 
     * depending on the catch rate calculation.
     * 
     * @return true if the enemy Creature is caught, otherwise false.
     */
    public boolean catchCreature(){
        double catchRate = 40 + 50 - enemyCreature.getHealth();
        Random random = new Random();
        int nChance = random.nextInt(101);

        if(nChance <= catchRate){
            System.out.println("You caught [" + enemyCreature.getName() + "]!");
            CPlayer.addToInventory(enemyCreature);
            return true;
        } 
        
        else {
            System.out.println("You were not able to catch it! ");
            return false;
        } 

    }
}
