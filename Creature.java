/**
 * The Creature class represents a Creature containing attributes such as the
 * name, type, family, evolution level, and health.
 * <p>
 * This class also provides methods to retrieve information of its attributes
 * such as the name, type, family, evolution level, and health, as well as
 * display them.
 * 
 */
public class Creature {
    /**
     * The Creature's name.
     */
    private String strName;

    /**
     * The Creature's type.
     */
    private String strType;

    /**
     * The family that the Creature belongs to.
     */
    private char cFamily;

    /**
     * The Creature's evolution level.
     */
    private int nEL;

    /**
     * The Creature's health.
     */
    private double dHealth;

    /**
     * Constructs a new Creature object.
     * 
     * @param strName  the name of the Creature
     * @param strType  the type of Creature
     * @param cFamily  the family that the Creature belongs to
     * @param nEL      the evolution level of the Creature
     */
    public Creature(String strName, String strType, char cFamily, int nEL){
        this.strName = strName;
        this.strType = strType;
        this.cFamily = cFamily;
        this.nEL = nEL;
    }

    /**
     * Displays the Creature's information.
     * This includes the name, type, family, and evolution level.
     */
    public void displayCreature(){
        System.out.println("Creature Name            :  " + this.strName);
        System.out.println("Creature Type            :  " + this.strType);
        System.out.println("Creature Family          :  " + this.cFamily);
        System.out.println("Creature Evolution Level :  " + this.nEL);
    }

    /**
     * Sets the health of the creature.
     * 
     * @param dHealth  the health of the Creature
     */
    public void setHealth(double dHealth){
        this.dHealth = dHealth;
    }
    
    /**
     * Gets the Creature's name.
     * 
     * @return the name of the Creature
     */
    public String getName(){
        return strName;
    }

    /**
     * Gets the Creature's type.
     * 
     * @return the type of the Creature
     */
    public String getType(){
        return strType;
    }

    /**
     * Gets the Creature's family.
     * 
     * @return the family of the Creature
     */
    public char getFamily(){
        return cFamily;
    }

    /**
     * Gets the Creature's evolution level.
     * 
     * @return the evolution level of the Creature
     */
    public int getEL(){
        return nEL;
    }

    /**
     * Gets the Creature's health.
     * 
     * @return the health of the Creature
     */
    public double getHealth(){
        return this.dHealth;
    }

    
}
