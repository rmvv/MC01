import java.util.Random;
import java.util.Scanner;

/**
 * The CreatureGame class represents a game that acts similar to Pokemon, where players can interact
 * with Creatures in different ways.
 * <p>
 * Players are prompted to choose a starter creature from a list at the start of the game. They are 
 * then allowed to navigate through various areas and engage in battles against random enemy Creatures 
 * they encounter.
 * <p>
 * The game also provides a series of actions for the player to do, such as viewing their inventory,
 * choosing an area to explore, and evolving Creatures in their inventory.
 * </p>
 */
public class CreatureGame {
    /**
     * The player in the game.
     */
    private Player CPlayer;
    
    /**
     * The area the player is exploring.
     * This object generates a grid depending on the player's choice.
     */
    private Area CArea;
    private Scanner scanner;

    private Battle CBattle;

    /**
     * Runs the game.
     */
    public void runGame() {
        scanner = new Scanner(System.in);
        Random random = new Random();

        String strPlayerName;
        int nChoice = 0, nStarter = 0, i;
        ActionMenu actionMenu = new ActionMenu();
        
        Creature Strawander = new Creature("Strawander", "Fire", 'A', 1);
        Creature Chocowool = new Creature("Chocowool", "Fire", 'B', 1);
        Creature Parfwit = new Creature("Parfwit", "Fire", 'C', 1);
        Creature Brownisaur = new Creature("Brownisaur", "Grass", 'D', 1);
        Creature Frubat = new Creature("Frubat", "Grass", 'E', 1);
        Creature Malts = new Creature("Malts", "Grass", 'F', 1);
        Creature Squirpie = new Creature("Squirpie", "Water", 'G', 1);
        Creature Chocolite = new Creature("Chocolite", "Water", 'H', 1);
        Creature Oshacone = new Creature("Oshacone", "Water", 'I', 1);
        Creature[] EL1 = {Strawander, Chocowool, Parfwit, Brownisaur, Frubat, Malts, Squirpie, Chocolite, Oshacone};

        actionMenu.displayMenu(ActionMenu.MenuType.GAME_START);

        System.out.print("Enter your player name: ");
        strPlayerName = scanner.nextLine();
        CPlayer = new Player(strPlayerName);

        System.out.println("\nChoose A Starter Pokemon!");
        for (i = 0; i < EL1.length; i++) {
            System.out.println("[" + (i + 1) + "] " + EL1[i].getName() + " - " + EL1[i].getType());
        }

        do {
            if (scanner.hasNextInt()) {
                nStarter = scanner.nextInt();
                if (nStarter < 1 || nStarter > 9) {
                    System.out.print("\nInvalid choice! Choose a valid option: ");
                }
            } else {
                System.out.print("\nInvalid input! Please enter a valid number: ");
                scanner.nextLine(); // Consume the invalid input
                continue;
            }
        } while (nStarter < 1 || nStarter > 9);
        

        if (nStarter >= 1 && nStarter <= 9) {
            CPlayer.addToInventory(EL1[nStarter - 1]);
            System.out.println("\nYou chose [" + EL1[nStarter - 1].getName() + "]!");
            CPlayer.setActiveCreature(0);
            System.out.println("Your current active creature is [" + CPlayer.getActiveCreature().getName() + "]!");
        }

        boolean inGameRunning = true;

        while (inGameRunning) {
            actionMenu.displayMenu(ActionMenu.MenuType.HOME_MENU);

            if (scanner.hasNextInt()) {
                nChoice = scanner.nextInt();
            } 
            
            else {
                System.out.println("Invalid input! Please enter a valid option.");
                scanner.next();
                continue;
            }

            if (nChoice == 1) {
                CPlayer.displayPlayerInventory();
            } else if (nChoice == 2) {
                int width, height;
                System.out.println("\nChoose an area: \n[1] Area 1 (5 x 1)\n[2] Area 2 (3 x 3)\n[3] Area 3 (4 x 4)");

                if (scanner.hasNextInt()) {
                    int areaChoice = scanner.nextInt();
                    switch (areaChoice) {
                        case 1:
                            width = 5;
                            height = 1;
                            break;
                        case 2:
                            width = 3;
                            height = 4;
                            break;
                        case 3:
                            width = 4;
                            height = 4;
                            break;
                        default:
                            System.out.println("Invalid choice! Choose a valid option");
                            continue; // Continue the loop to re-enter a valid choice
                    }

                    CArea = new Area(width, height);
                    boolean areaNavigationRunning = true;
                    boolean enemyEncountered = false;

                    while (areaNavigationRunning) {
                        System.out.println("\nChoose a direction: [1] Up,  [2] Down, [3] Left, [4] Right, [5] Exit");
                        CArea.displayArea();

                        int moveChoice = 0;
                        boolean validMove = false;

                        while (!validMove) {
                            if (scanner.hasNextInt()) {
                                moveChoice = scanner.nextInt();
                        
                                switch (moveChoice) {
                                    case 1:
                                        CArea.moveUp();
                                        enemyEncountered = random.nextInt(100) < 40;
                                        validMove = true;
                                        break;
                                    case 2:
                                        CArea.moveDown();
                                        enemyEncountered = random.nextInt(100) < 40;
                                        validMove = true;
                                        break;
                                    case 3:
                                        CArea.moveLeft();
                                        enemyEncountered = random.nextInt(100) < 40;
                                        validMove = true;
                                        break;
                                    case 4:
                                        CArea.moveRight();
                                        enemyEncountered = random.nextInt(100) < 40;
                                        validMove = true;
                                        break;
                                    case 5:
                                        areaNavigationRunning = false;
                                        validMove = true;
                                        break;
                                    default:
                                        System.out.println("Invalid choice! Choose a valid option");
                                        scanner.nextLine(); 
                                        break; 
                                }
                            } 
                            
                            else {
                                System.out.println("Invalid choice! Please enter a valid option");
                                scanner.nextLine();
                            }
                        }

                        scanner.nextLine();
                        
                        if (enemyEncountered && moveChoice != 5) {
                            Creature randomEnemy = EL1[random.nextInt(EL1.length)];
                            CBattle = new Battle(CPlayer, randomEnemy, scanner);
                            CBattle.commenceBattle();
                        }
                    }
                } 
                
                else {
                    System.out.println("Invalid input! Please enter a valid option.");
                    scanner.next(); 
                }
            } 
            
            else if (nChoice == 3) {
                System.out.println("IN PROGRESS!\n");
            } 
            
            else if (nChoice == 4) {
                System.out.println("\nThanks for playing!");
                inGameRunning = false;
            } 
            
            else {  
                System.out.println("Invalid choice! Choose a valid option");
            }
        }
        scanner.close();
    }
}