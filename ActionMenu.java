/**
 * The ActionMenu class provides methods to display various menus in a game.
 */
public class ActionMenu {
    /**
     * Enum representing the types of menus available.
     */
    public enum MenuType {
        /**
         * The main menu displaying the actions the player can choose from.
         */
        HOME_MENU,
        /**
         * The menu displayed at the start of the game.
         */
        GAME_START
    }

    /**
     * Displays the menu based on the corresponding menu type.
     * 
     * @param menuType  the type of menu to be displayed
     */
    public void displayMenu(MenuType menuType){
        switch(menuType){
            case GAME_START:
                gameStart();
                break;
            case HOME_MENU:
                homeMenu();
        }
    }

    /**
     * Displays the title of the game at the start.
     */
    private void gameStart(){
        System.out.println("------------------------------------");
        System.out.println("         WELCOME TO [CREATURE]!      ");
        System.out.println("------------------------------------");
        System.out.println();
    }

    /**
     * Displays the home menu with options the player chooses from.
     */
    private void homeMenu(){
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("[1] View Inventory");
        System.out.println("[2] Explore an Area");
        System.out.println("[3] Evolve Creature");
        System.out.println("[4] Exit");
    }

}
