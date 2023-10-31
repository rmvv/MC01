import java.util.ArrayList;

/**
 * The Inventory class represents the list of Creatures the player has on them.
 * <p>
 * This class contains methods for handling the inventory, including tasks like 
 * adding and removing Creatures, displaying the contents of the inventory, 
 * and retrieving specific Creatures. 
 * </p>
 */
public class Inventory {
    /**
     * The list where the player's Creatures are stored.
     */
    private ArrayList<Creature> CInventory;
    
    public Inventory(){
        this.CInventory = new ArrayList<>();
    }

    /**
     * Adds the provided Creature to the inventory.
     * This method creates a new creature based on the attributes of the provided 
     * by given Creature (name, type, family, and experience level), and then adds 
     * it to the inventory.
     * 
     * @param tempCreature the Creature object to be added to the inventory
    */
    public void addCreature(Creature tempCreature){
        Creature addedCreature = new Creature(tempCreature.getName(), tempCreature.getType(), tempCreature.getFamily(), tempCreature.getEL());
        CInventory.add(addedCreature);
    }

    /**
     * Removes the provided Creature from the inventory.
     *
     * @param tempCreature the Creature object to be removed from the inventory
    */
    public void removeCreature(Creature tempCreature){
        CInventory.remove(tempCreature);
    }
    
    /** 
     * Displays all the Creatures stored in the Inventory (ArrayList).
     */
    public void displayInventory(){
        int i = 0;
        for(Creature creature : CInventory){
            i++;
            System.out.println("[" + i +"]");
            creature.displayCreature();
            System.out.println();
        }

    }

    /** 
    * This method returns the Creature in the Inventory given the index.
    *
    * @param index      the index of the Creature in the inventory
    * @return the Creature in the inventory 
    */
    public Creature getCreature(int index){
        return CInventory.get(index);
    }

    /** 
     * Returns the size of the Inventory.
     *
     * @return the inventory size 
     */
    public int getInventorySize(){
        return CInventory.size();
    }
}
