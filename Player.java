import java.util.Scanner;

/**
 * The Player class represents a player in the game. Each player has a name, an inventory
 * of Creatures, and an active Creature they control.
 * <p>
 * The player is able to perform actions such as adding and removing Creatures from their
 * inventory, displaying their inventory, and changing their active Creature. In addition,
 * it is possible to retrieve information such as the name, inventory size, and active Creature
 * using methods provided in this class. 
 * </p>
 */
public class Player {
    /**
     * The player's name.
     */
    private String strName;

    /**
     * The list of Creatures in the player's possesion.
     */
    private Inventory CInventory;

    /**
     * The player's current active Creature.
     */
    private Creature activeCreature;

    static Scanner scanner = new Scanner(System.in);

    /**
    * Constructs a new Player with the specified name and adds an Inventory.
    *
    * @param strName  the name of the player.
    */
    public Player(String strName){
        this.strName = strName;
        this.CInventory = new Inventory();
    }


    /**
     * Adds a specified Creature to the inventory.
     * The Creature will be included in the list of creatures held by the inventory.
     *
     * @param tempCreature  the Creature object to be added to the inventory.
     * @see Inventory#addCreature(Creature)
     */
    public void addToInventory(Creature tempCreature){
        CInventory.addCreature(tempCreature);
    }

    /**
     * Removes a specified creature from the inventory.
     * 
     * @param tempCreature  the creature to be removed from the inventory.
     * @see Inventory#removeCreature(Creature)
     */
    public void removeFromInventory(Creature tempCreature){
        CInventory.removeCreature(tempCreature);
    }

    /**
     * Displays all the Creatures stored in the player's inventory.
     */
    public void showInventory() {
        this.CInventory.displayInventory();
    }

    /**
     * Displays the contents of the inventory and allows the user to make changes 
     * to their active Creature.
     * If the user has only one Creature in their inventory, it does not allow the 
     * user to swap and displays an error message, suggesting to catch more Creatures.
     */
    public void displayPlayerInventory() {
        char cSwap = ' ';
        int newCreature = 0;
        System.out.println("\n[" + this.strName + "]'s Inventory");
        System.out.println("Active Creature: [" + activeCreature.getName() + "]");
        System.out.println();
        showInventory();
    
        System.out.println("Would you like to change active creature? [Y/N]");
    
        do {
            String input = scanner.next();
            if (input.length() != 1) {
                System.out.print("Invalid choice! Please enter 'Y' or 'N': ");
                continue;
            }
            cSwap = input.charAt(0);
    
            if (cSwap != 'Y' && cSwap != 'y' && cSwap != 'N' && cSwap != 'n') {
                System.out.print("Invalid choice! Please enter 'Y' or 'N': ");
            }
    
        } while (cSwap != 'Y' && cSwap != 'y' && cSwap != 'N' && cSwap != 'n');
    
        if ((cSwap == 'Y' || cSwap == 'y') && CInventory.getInventorySize() != 1) {
            System.out.println("Choose a creature from your inventory: ");
            CInventory.displayInventory();
    
            do {
                if (scanner.hasNextInt()) {
                    newCreature = scanner.nextInt();
    
                    if (newCreature < 1 || newCreature > CInventory.getInventorySize()) {
                        System.out.print("Invalid choice! Choose a valid option: ");
                    }
                } 
                
                else {
                    System.out.print("Invalid choice! Please enter a valid option: ");
                    scanner.next(); // Consume the invalid input
                }
    
            } while (newCreature < 1 || newCreature > CInventory.getInventorySize());
    
            if (newCreature >= 1 && newCreature <= CInventory.getInventorySize()) {
                setActiveCreature(newCreature - 1);
                System.out.println("\nYour new Active Creature is [" + activeCreature.getName() + "]!");
            }
        } 
        
        else if ((cSwap == 'Y' || cSwap == 'y') && CInventory.getInventorySize() == 1) {
            System.out.println("Sorry! You can't swap [Active Creature] because you only have [1] Creature in your Inventory.\nTry to catch more Creatures!");
        }
    }
    

    /**
     * Sets the active creature by retrieving it from the creature inventory using the provided index.
     *
     * @param index The index of the creature in the inventory to set as active.
    */
    public void setActiveCreature(int index){
        this.activeCreature = CInventory.getCreature(index);
    }

    /**
     * Gets the player's name.
     * 
     * @return the String component containing the player's name
     */
    public String getName(){
        return strName;
    }

    /**
     * Gets the number of Creatures in the player's inventory.
     * 
     * @return the inventory size of the player
     */
    public int getInventorySize(){
        return CInventory.getInventorySize();
    }

    /**
     * Gets the current active Creature.
     * 
     * @return the current active Creature of the player
     */
    public Creature getActiveCreature(){
        return activeCreature;
    }

}



